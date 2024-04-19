package exercicioFixacao_Aula_03;

import java.util.Scanner;

public class Principal {
	final static Scanner INP = new Scanner(System.in);

	public static void main(String[] args) {
		exercicio1();
		exercicio2();
		exercicio3();
	}
	
	public static void exercicio1() {
		Funcionario f1 = new Funcionario("Roger", 1500);
		
		System.out.println(f1.calcularINSS());
		System.out.println(f1.calcularVT());
		System.out.println(f1.getNome());
		System.out.println(f1.getSalario());
	}
	
	public static void exercicio2() {
		boolean continua;
		
		do {
			System.out.println("Informe o nome do produto: ");
			String desc = INP.next();
			System.out.println("Informe o valor: ");
			double valor = INP.nextDouble();
			System.out.println("Informe a quantidade: ");
			int qtd = INP.nextInt();
			
			Produto p1 = new Produto(desc, valor, qtd);
			
			System.out.println(p1.toString());
			
			System.out.println("Deseja encerrar o programa? (S/N)");
			char opc = INP.next().toUpperCase().charAt(0);
			
			if(opc == 'S') {
				continua = false;
				System.out.println("Programa encerrado...");
			}else {
				continua = true;
				System.out.println("Reiniciando o programa...");
			}
			
		}while(continua);
	}
	
	public static void exercicio3() {
		
	}


}
