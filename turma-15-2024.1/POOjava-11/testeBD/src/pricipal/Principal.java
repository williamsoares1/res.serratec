package pricipal;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

import connect.ContaAcesso;
import connect.FuncoesBD;

public class Principal {
	static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {		
	 	FuncoesBD bd = new FuncoesBD();
	 	
	 	bd.createDB(conectarUser(bd), "testesBD");
	 	
	 	Connection coneccao = conectarDB(bd);
	 	
	 	//deletarTabela(bd, coneccao);
	}
	
	public static Connection conectarDB(FuncoesBD bd) {
		ContaAcesso c = new ContaAcesso();
		
		String usuario = c.getUsuario();
		String dbnome = c.getDbnome();
		String senha = c.getSenha();
	 	
	 	Connection conn = bd.connect_to_db(dbnome, usuario, senha);
	 	
	 	return conn;
	}
	
	public static Connection conectarUser(FuncoesBD bd) {
		ContaAcesso c = new ContaAcesso();
		
		Connection conn = bd.connect_to_user(c.getUsuario(), c.getSenha());
		
		return conn;
	}
	
	public static void deletarTabela(FuncoesBD bd, Connection conn) {
		System.out.println("Informe o nome do database a ser deletado: ");
	 	String dbNome = input.next();
	 	
		bd.delete_table(conn,dbNome);
	}

}
