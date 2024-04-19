package exercicio;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import exercicio.Cadastro;

public class Cadastro {
	
	final static Scanner INPUT = new Scanner(System.in);
	final static NumberFormat NF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	

	public static void main(String[] args) {
		Usuarios user1 = addUsuario();
		Usuarios user2 = addUsuario();
		user1.getInfo();
		user2.getInfo();
	}
	
	public static Usuarios addUsuario() {
		System.out.println("Informe o nome de usuario: ");
		String nome = INPUT.next();
		
		System.out.println("Informe o login: ");
		String login = INPUT.next();
		
		System.out.println("Informe a senha: ");
		String senha = INPUT.next();
		
		System.out.println("Informe o cargo do usuario: ");
		String cargo = INPUT.next();
		
		System.out.println("Informe o salario: ");
		double salario = INPUT.nextDouble();
		
		return new Usuarios(nome, login, senha, cargo, salario);
	}

}
