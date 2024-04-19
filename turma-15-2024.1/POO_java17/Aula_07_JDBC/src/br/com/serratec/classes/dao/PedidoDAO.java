package br.com.serratec.classes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.serratec.classes.Cliente;
import br.com.serratec.classes.PedItem;
import br.com.serratec.classes.Pedido;
//import br.com.serratec.classes.Produto;
import br.com.serratec.conexao.Conexao;
//import java.util.Date;

public class PedidoDAO {
	private Conexao conexao;
	private String schema;
	
	PreparedStatement pInclusaoPedido = null;
	PreparedStatement pInclusaoPedItem = null;
	
	public PedidoDAO(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusaoPedido();
		prepararSqlInclusaoPedItem();
	}
	
	private void prepararSqlInclusaoPedido() {
		String sql = "insert into "+ this.schema + ".pedido";
		sql = sql + " (numero, data, valorpedido, idcliente)";
		sql = sql + " values ";
		sql = sql + " (?, ?, ?, ?)";
		
		try {
			pInclusaoPedido =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			//System.err.println(e);
			//e.printStackTrace();
		}
	}
	
	private void prepararSqlInclusaoPedItem() {
		String sql = "insert into "+ this.schema + ".peditem";
		sql = sql + " (idpedido, idproduto, valorunitario, quantidade)";
		sql = sql + " values ";
		sql = sql + " (?, ?, ?, ?)";
		
		try {
			pInclusaoPedItem =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			//System.err.println(e);
			//e.printStackTrace();
		}
	}
	
	public int incluirPedido(Pedido pedido) {
		try {
			
			
			pInclusaoPedido.setString(1, pedido.getNumero());
			pInclusaoPedido.setDate(2, pedido.getDataPedido());
			pInclusaoPedido.setDouble(3, pedido.getValorPedido());
			pInclusaoPedido.setInt(4, pedido.getCliente().getIdcliente());
	
			
			return pInclusaoPedido.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedido não incluído.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}		
	}
	
	public int incluirPedItem(Pedido pedido, PedItem itens) {
		try {			
			pInclusaoPedItem.setInt(1, pedido.getIdpedido());
			pInclusaoPedItem.setInt(2, itens.getIdProduto());
			pInclusaoPedItem.setDouble(3, itens.getValorUnitario());
			pInclusaoPedItem.setDouble(4, itens.getQuantidade());
				
			return pInclusaoPedItem.executeUpdate();
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nPedItem não incluído.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}		
	}

	public void alterarPedido(Pedido pedido) {
		String sql = "update " +
						this.schema + ".pedido set " +
						"numero = '" + pedido.getNumero() + "'" +
						", idcliente = '" + pedido.getCliente().getIdcliente() + "'" +
						", valorpedido = '" + pedido.getValorPedido() + "'" +
						"where idpedido = " + pedido.getIdpedido();
		conexao.query(sql);
	}
	
	public Pedido selecionarPedido(String numero, int idpedido) {
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		PedItem itens = new PedItem();
		
		ResultSet tbPedido, tbCliente, tbItens;
		
		String sql;
		
		if (numero == null) {
			sql = "select * from " + this.schema + ".pedido where idpedido = " + idpedido;
		} else
			sql = "select * from " + this.schema + ".pedido where numero = '" + numero + "'";
		
		tbPedido = conexao.query(sql);
		
		try {

			if (tbPedido.next()) {
				sql = "select * from " + this.schema + ".cliente where idcliente = " + tbPedido.getInt("idcliente");
				
				tbCliente = conexao.query(sql);
				
				if (tbCliente.next()) {
					cliente.setCpf(tbCliente.getString("cpf"));
					cliente.setRg(tbCliente.getString("rg"));
					cliente.setEndereco(tbCliente.getString("endereco"));
					cliente.setNome(tbCliente.getString("nome"));
					cliente.setSexo(tbCliente.getString("sexo"));
				}
				
				sql = "select p.*, pi.valorunitario, pi.quantidade from " + this.schema + ".produto p " +
						"right join " + this.schema + ".peditem pi on pi.idproduto = p.idproduto " +
						"where pi.idpedido = " + tbPedido.getInt("idpedido"); 
				
				tbItens = conexao.query(sql);
				
				pedido.setIdpedido(tbPedido.getInt("idpedido"));
				pedido.setCliente(cliente);
				pedido.setDataPedido(tbPedido.getDate("data"));
				pedido.setValorPedido(tbPedido.getDouble("valorpedido"));
				pedido.setNumero(tbPedido.getString("numero"));
				
				tbItens.beforeFirst();
				
				while (tbItens.next()) {
					itens.setDescricao(tbItens.getString("descricao"));
					itens.setIdProduto(tbItens.getInt("idproduto"));
					itens.setQuantidade(tbItens.getDouble("quantidade"));
					itens.setValorUnitario(tbItens.getDouble("valorunitario"));
					itens.setVlCusto(tbItens.getDouble("custo"));
					itens.setVlPreco(tbItens.getDouble("preco"));
					
					pedido.adicionarProduto(itens);
				}
				
				tbItens.close();				
				tbCliente.close();
			} else
				System.out.println("IdPedido " + idpedido + " não localizado.");
			
			tbPedido.close();
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		return pedido;
	}
	
	public void apagarPedido(int idpedido) {
		
		String sql = "delete from " + this.schema + ".peditem" +
				" where idpedido = " + idpedido;
		
		conexao.query(sql);
		
		sql = "delete from " + this.schema + ".pedido" +
						" where idpedido = " + idpedido;
		
		conexao.query(sql);		
	}
	
	public void listarPedidos() {
		ResultSet tabela;		
		
		String sql = "select p.*, c.cpf, c.endereco, c.nome, c.rg, c.sexo "+
						"from " + this.schema + ".pedido p "+ 
						"left join " + this.schema + ".cliente c on c.idcliente = p.idcliente "+
						"order by idpedido";
		
		tabela = conexao.query(sql);
		
		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de pedidos: " +rowCount);
			
			if (rowCount > 0) {
				System.out.println("\nDADOS DO PEDIDO");
				System.out.println("---------------------------------------------------------------------");		
				System.out.println("Número\t\tData\t\tCliente\tCPF\t\tValor Total");
			} else {
				System.out.println("\nNão possui dados.");
				return; 
			}
			
			tabela.beforeFirst();
			
			while (tabela.next()) {
				System.out.printf("%s\t%s\t%-20s\t%s\t\t%s\t%2.2f\n",
						tabela.getString("numero"),
						tabela.getString("data"),
						tabela.getString("nome"),
						tabela.getString("cpf"),
						tabela.getString("valorpedido")						
						);
			}
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
