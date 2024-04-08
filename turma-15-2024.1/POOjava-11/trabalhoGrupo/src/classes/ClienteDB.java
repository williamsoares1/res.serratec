package classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.DB;

public class ClienteDB {
	
	// Essa funcao vai buscar todos os CLientes
	
	public static ArrayList<Cliente> buscarTodosClientes() {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		try (Connection connection = DB.connect()) {
			Statement statement = connection.createStatement();
			// O var eh utilizado para declarar uma variavel sem precisar explicitar o tipo, normalmente utilizado dentro de funcoes de forma encapsulada
			var response = statement.executeQuery(sql);
			// executar a resposta enquanto tiver cliente dentro do array, usando o next 
			while (response.next()) { // String nome, String cpf, Date data_nascimento, int idCliente, String endereco, String telefone
				Cliente cliente = new Cliente(
						response.getString("nome"),
						response.getString("cpf"),
						response.getDate("dtnascimento"),
						response.getInt("idcliente"),
						response.getString("endereco"),
						response.getString("telefone")
						
						);
				clientes.add(cliente);
				
			}
			
		} catch (SQLException error) {
			System.err.println(error.getMessage());
		}
		return clientes;
		
	}
}
