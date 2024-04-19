package br.com.serratec.classes.dao;

import br.com.serratec.conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.serratec.classes.Cliente;

public class ClienteDAO {
	//Crio o atributo de conexão que receberá a conexão do sistema
	private Conexao conexao;
	//Crio o atributo schema que receberá a conexão do sistema
	private String schema;
	
	PreparedStatement pInclusao = null; 
	
	//Construtor da classe que recebe a conexão e o schema
	public ClienteDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".cliente";
		sql += " (nome, cpf, endereco, rg, sexo, dtnasc)";
		sql += " values ";
		sql += " (?, ?, ?, ?, ?, ?)";
		
		try {
			pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			//System.err.println(e);
			//e.printStackTrace();
		}
	}
	
	public int incluirCliente(Cliente cliente) {
		try {
			pInclusao.setString(1, cliente.getNome());
			pInclusao.setString(2, cliente.getCpf());
			pInclusao.setString(3, cliente.getEndereco());
			pInclusao.setString(4, cliente.getRg());
			pInclusao.setString(5, cliente.getSexo());
			pInclusao.setString(6, cliente.getSexo());
			
			return pInclusao.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nCliente não incluído.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
		
	}
	
	public void incluirClienteNaoServe(Cliente cliente) {
	//public void incluirCliente(String nome, String cpf, String rg, String endereco) {
		//Cabeçalho acima não recomendado
		String sql = "insert into " +
						this.schema + ".cliente " +
						"(nome, cpf, endereco, rg, sexo) " +
						"values " +
						" (" +
							cliente.getNome() + "," +
							cliente.getCpf() + ", " +
							cliente.getEndereco() + ", " +
							cliente.getRg() + ", " +
							cliente.getSexo() +
						")";
		conexao.query(sql); //executa o comando sql pelo objeto de conexão
	}
	
	public void alterarCliente(Cliente cliente) {
		String sql = "update " +
						this.schema + ".cliente set " +
						"nome = '" + cliente.getNome() + "'" +
						", cpf = '" + cliente.getCpf() + "'" +
						", endereco = '" + cliente.getEndereco() + "'" +
						", rg = '" + cliente.getRg() + "' " +
						"where idcliente = " + cliente.getIdcliente();
		conexao.query(sql);
	}
	
	// Método que busca um cliente a partir do seu idcliente (código)
	// Retorna para quem chamou um objeto Cliente com todos os dados do cliente encontrado
	public Cliente selecionarCliente(int idCliente) {
		Cliente cliente = new Cliente();
		ResultSet tabela;
		
		String sql = "select * from " + this.schema + ".cliente where idcliente = " + idCliente;
		
		tabela = conexao.query(sql);
		
		try {
			// tabela.next vai para o próxima linha da tabela
			// o result começa antes da primeira linha
			if (tabela.next()) {
				cliente.setIdcliente(tabela.getInt("idcliente"));
				cliente.setNome		(tabela.getString("nome"));
				cliente.setCpf		(tabela.getString("cpf"));
				cliente.setRg		(tabela.getString("rg"));
				cliente.setEndereco	(tabela.getString("endereco"));
			} else
				System.out.println("IdCliente " + idCliente + " não localizado.");
			
			tabela.close();	
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void apagarCliente(int idCliente) {
		String sql = "delete from " + this.schema + ".cliente" +
						" where idcliente = " + idCliente;
		
		conexao.query(sql);		
	}
	/**
	 * 
	 * @param nome
	 * @param idCliente
	 * @return
	 */
	public Cliente localizarCliente(String nome, int idCliente) {
		Cliente cliente = new Cliente();
		
		String sql;
		ResultSet tabela;
		
		if (nome == null) {
			sql = "select * from " + this.schema + ".cliente where idcliente = " + idCliente;
		} else
			sql = "select * from " + this.schema + ".cliente where nome = '" + nome + "'";
		
		tabela = conexao.query(sql);
		
		try {
			// tabela.next vai para a próxima linha da tabela
			// o ResultSet começa antes da primeira linha
			if (tabela.next()) {
				cliente.setIdcliente(tabela.getInt("idcliente"));
				cliente.setNome		(tabela.getString("nome"));
				cliente.setCpf		(tabela.getString("cpf"));
				cliente.setRg		(tabela.getString("rg"));
				cliente.setEndereco	(tabela.getString("endereco"));
			} else {
				if (nome == null) {
					System.out.println("IdCliente " + idCliente + " não localizado.");
				} else
					System.out.println("Cliente '" + nome + "' não localizado.");
				
				cliente = null;
			}
			
			tabela.close();	
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void listarClientes() {
		ResultSet tabela;		
		
		String sql = "select * from " + this.schema + ".cliente order by idcliente";
		
		tabela = conexao.query(sql);
		
		try {
			tabela.last(); //segue para a última linha da tabela
			int rowCount = tabela.getRow(); // pega o número da linha (que no caso é a última)
			System.out.println("Quantidade de clientes: " +rowCount);
			
			if (rowCount > 0) {
				System.out.println("\nCódigo\tNome\t\t\tCPF\t\tEndereço");
			} else {
				System.out.println("\nNão possui dados.");
				return; // Aqui chamo o return para sair do método
						// O return é void (vazio)
			}
			
			tabela.beforeFirst();
			
			while (tabela.next()) {
				System.out.printf("%s\t%-20s\t%s\t%s\n",
						tabela.getInt("idcliente"),
						tabela.getString("nome"),
						tabela.getString("cpf"),
						tabela.getString("endereco")
						);
			}
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
