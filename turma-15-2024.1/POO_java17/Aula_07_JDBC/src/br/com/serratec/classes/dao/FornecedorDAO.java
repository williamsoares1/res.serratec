package br.com.serratec.classes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.serratec.classes.Fornecedor;
import br.com.serratec.conexao.Conexao;

public class FornecedorDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pInclusao = null; 
	
	//Construtor da classe que recebe a conexão e o schema
	public FornecedorDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".fornecedor";
		sql = sql + " (razaosocial, nmfantasia, endereco, cnpj)";
		sql = sql + " values ";
		sql = sql + " (?, ?, ?, ?)";
		
		try {
			pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			//System.err.println(e);
			//e.printStackTrace();
		}
	}
	
	public int incluirFornecedor(Fornecedor fornecedor) {
		try {
			pInclusao.setString(1, fornecedor.getRazaoSocial());
			pInclusao.setString(2, fornecedor.getNmFantasia());
			pInclusao.setString(3, fornecedor.getEndereco());
			pInclusao.setString(4, fornecedor.getCnpj());
	
			
			return pInclusao.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nForencedor não incluído.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}		
	}
	/*
	public void incluirfornecedorNaoServe(fornecedor fornecedor) {
	//public void incluirfornecedor(String nome, String cpf, String rg, String endereco) {
		//Cabeçalho acima não recomendado
		String sql = "insert into " +
						this.schema + ".fornecedor " +
						"(nome, cpf, endereco, rg, sexo) " +
						"values " +
						" (" +
							fornecedor.getNome() + "," +
							fornecedor.getCpf() + ", " +
							fornecedor.getEndereco() + ", " +
							fornecedor.getRg() + ", " +
							fornecedor.getSexo() +
						")";
		conexao.query(sql); //executa o comando sql pelo objeto de conexão
	}
	*/
	public void alterarFornecedor(Fornecedor fornecedor) {
		String sql = "update " +
						this.schema + ".fornecedor set " +
						"razaosocial = '" + fornecedor.getRazaoSocial() + "'" +
						", nmfantasia = '" + fornecedor.getNmFantasia() + "'" +
						", endereco = '" + fornecedor.getEndereco() + "'" +
						", cnpj = '" + fornecedor.getCnpj() + "' " +
						"where idfornecedor = " + fornecedor.getIdfornecedor();
		conexao.query(sql);
	}
	
	public Fornecedor selecionarfornecedor(int idfornecedor) {
		Fornecedor fornecedor = new Fornecedor();
		ResultSet tabela;
		
		String sql = "select * from " + this.schema + ".fornecedor where idfornecedor = " + idfornecedor;
		
		tabela = conexao.query(sql);
		
		try {

			if (tabela.next()) {
				fornecedor.setIdfornecedor(tabela.getInt("idfornecedor"));
				fornecedor.setRazaoSocial(tabela.getString("razaosocial"));
				fornecedor.setNmFantasia(tabela.getString("nmfantasia"));
				fornecedor.setCnpj		(tabela.getString("cnpj"));
				fornecedor.setEndereco	(tabela.getString("endereco"));
			} else
				System.out.println("Idfornecedor " + idfornecedor + " não localizado.");
			
			tabela.close();	
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return fornecedor;
	}
	
	public void apagarfornecedor(int idfornecedor) {
		String sql = "delete from " + this.schema + ".fornecedor" +
						" where idfornecedor = " + idfornecedor;
		
		conexao.query(sql);		
	}
	
	public Fornecedor localizarfornecedor(String razaoSocial, int idfornecedor) {
		Fornecedor fornecedor = new Fornecedor();
		
		String sql;
		ResultSet tabela;
		
		if (razaoSocial == null) {
			sql = "select * from " + this.schema + ".fornecedor where idfornecedor = " + idfornecedor;
		} else
			sql = "select * from " + this.schema + ".fornecedor where razaosocial = '" + razaoSocial + "'";
		
		tabela = conexao.query(sql);
		
		try {

			if (tabela.next()) {
				fornecedor.setIdfornecedor(tabela.getInt("idfornecedor"));
				fornecedor.setRazaoSocial(tabela.getString("razaosocial"));
				fornecedor.setNmFantasia(tabela.getString("nmfantasia"));
				fornecedor.setCnpj(tabela.getString("cnpj"));
				fornecedor.setEndereco	(tabela.getString("endereco"));
			} else {
				if (razaoSocial == null) {
					System.out.println("Idfornecedor " + idfornecedor + " não localizado.");
				} else
					System.out.println("Fornecedor '" + razaoSocial + "' não localizado.");
				
				fornecedor = null;
			}
			
			tabela.close();	
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return fornecedor;
	}
	
	public void listarfornecedors() {
		ResultSet tabela;		
		
		String sql = "select * from " + this.schema + ".fornecedor order by idfornecedor";
		
		tabela = conexao.query(sql);
		
		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de fornecedores: " +rowCount);
			
			if (rowCount > 0) {
				System.out.println("\nCódigo\tRazao Social\t\t\tNome Fantasia\t\tCNPJ\t\tEndereço");
			} else {
				System.out.println("\nNão possui dados.");
				return; 
			}
			
			tabela.beforeFirst();
			
			while (tabela.next()) {
				System.out.printf("%s\t%-20s\t\t%s\t\t%s\t%s\n",
						tabela.getInt("idfornecedor"),
						tabela.getString("razaosocial"),
						tabela.getString("nmfantasia"),
						tabela.getString("cnpj"),
						tabela.getString("endereco")
						);
			}
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
