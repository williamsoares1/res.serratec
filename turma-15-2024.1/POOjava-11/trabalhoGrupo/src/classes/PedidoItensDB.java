package classes;

import java.sql.Statement;
import java.util.ArrayList;

import database.DB;

public class PedidoItensDB{
	public static ArrayList<PedidoItens> relacaoPedidoItem(){
		ArrayList<PedidoItens> relacao = new ArrayList<PedidoItens>();
		
		String sql = """
				SELECT 
			    pi.idpedidoitem,
			    p.idpedido,
				p.dtemissao,
				p.dtentrega,
				p.valortotal,
				p.observacao,
			    c.idcliente,
			    c.nome,
			    c.cpf,
			    c.dtnascimento,
			    c.endereco,
			    c.telefone,
			    pr.idproduto,
			    pr.descricao,
			    pr.vlcusto,
			    pr.quantidade,
			    pr.vlvenda,
			    pr.categoria,
			    pi.vlunitario,
			    pi.qtproduto,
				pi.vldesconto
				FROM 
				    public.pedidoitens pi
				JOIN 
				    public.produto pr ON pi.idproduto = pr.idproduto
				JOIN
				    public.pedido p ON pi.idpedido = p.idpedido
				JOIN
				    public.cliente c ON pi.idcliente_pedidoitens = c.idcliente;
				""";
		
		try(var conn = DB.connect()){
			Statement statement = conn.createStatement();
			var response = statement.executeQuery(sql);
			
			int qtd = 0;
			
			while(response.next()) {
				Produto produto = new Produto(
						response.getInt("idproduto"),
						response.getDouble("vlcusto"),
						response.getDouble("vlvenda"),
						response.getInt("quantidade"),
						response.getString("descricao"),
						response.getString("categoria")
						);
				
				Pedido pedido = new Pedido(
						response.getInt("idpedido"),
						response.getDate("dtemissao"),
						response.getDate("dtentrega"),
						response.getDouble("valortotal"),
						response.getString("observacao")
						);
				
				Cliente cliente = new Cliente(
						response.getString("nome"),
						response.getString("cpf"),
						response.getDate("dtnascimento"),
						response.getInt("idcliente"),
						response.getString("endereco"),
						response.getString("telefone")
						
						);
				
				//(double valorUnitario, double valorDesconto, Produto produto, int idPedidoitem, int quantidade_produto)
				qtd = response.getInt("qtproduto");
				
				PedidoItens pedidoItem = new PedidoItens(produto.getValorVenda() * qtd,
														 response.getDouble("vldesconto"),
														 produto,
														 cliente,
														 pedido,
														 response.getInt("idpedidoitem"),
														 qtd
														);
				relacao.add(pedidoItem);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}
		return relacao;
	}
}
