package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DB;

public class PedidoDB {
		
	public static ArrayList<Pedido> buscarTodosPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		String sql = "SELECT * FROM pedido";
		try (Connection connection = DB.connect()) {
			Statement statement = connection.createStatement();
			var response = statement.executeQuery(sql);
			while (response.next()) {
				Pedido pedido = new Pedido(
						response.getInt("idpedido"),
						response.getDate("dtemissao"),
						response.getDate("dtentrega"),
						response.getDouble("valortotal"),
						response.getString("observacao")
						);
				
				pedidos.add(pedido);
						
			}
		} catch (SQLException error) {
			System.err.println(error.getMessage());
		}
		return pedidos;
		
	}
}