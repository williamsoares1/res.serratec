package pricipal;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import classes.ClienteArrayList;
import connect.ContaAcesso;
import connect.FuncoesBD;

public class Principal {
	static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {		
	 	//inserindoNaLista();
	 	
	 	String cpf = input.next();
	 	System.out.println(formatarCPF(cpf));
	 	
	 	System.out.println(removerSimbolosCPF(formatarCPF(cpf)));

	 	//deletarTabela(bd, coneccao);
	}
	
	public static String formatarCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
	
	public static String removerSimbolosCPF(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
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
	
	public static void inserindoNaLista() {
		ClienteArrayList cliente = new ClienteArrayList("Jubileu", "Do pica-pau", 12);
		
		ArrayList<ClienteArrayList> c = new ArrayList<ClienteArrayList>();
		
		c.add(cliente);
		
		System.out.println(c.toString());
	}

}
