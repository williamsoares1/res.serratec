package excecoes;

import java.util.Scanner;

import banco.Conta;
import banco.ContaCorrente;
import banco.SaldoNegativo;
import banco.ValorInvalido;

public class Principal {
	public static void main(String[] args) {
		//frase();
		//tratamentos();
		contas();
	}
	
	public static void frase() {
		Scanner input = new Scanner(System.in);
		String fraseEntrada = null;
		String fraseSaida = null;
		boolean continua = false;
		String valor;
		char resposta;
		
		do {
			try {
				continua = false;
				System.out.println("Quer informar valor? (S/N)");
				resposta = input.next().charAt(0);
				
				if (resposta == 'S') {
					fraseEntrada = "Deixou de ser nulo";
				}
				
				fraseSaida = fraseEntrada.toUpperCase();
				System.out.println("Resultado: " + fraseSaida);
			} catch (Exception e){
				System.out.println("Falha ao colocar em maiúsculo.");
				System.out.println("Erro: " + e.getMessage());
				continua = true;
			}
		} while (continua);
		
		System.out.println("Finalizando o sistema.");
	}

	public static void tratamentos() {
		int vetor[] = {10,3,5};
		int a = 10;
		int b = 0;
		int c = 0;
		String str = null;
		
		try {
			//c = a / b;
			//System.out.println("Resultado de c: " + c);
			//System.out.println("Resultado de vetor: " + vetor[3]);
			System.out.println("Resultado: " + str.equals("cdd"));
		} catch(ArithmeticException e) {
			System.out.println("Falha ao realizar divisao.");
			System.out.println("Erro: "+ e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Falha ao acessar o índice do vetor");
			System.out.println("Erro: " + e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("Falha ao chamar método de objeto nulo.");
			System.out.println("Erro: " + e.getMessage());
		} catch(Exception e) {
			System.out.println("Falha no programa.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println("\nPrograma finalizado.");
	}

	public static void contas() {
		Conta cc = new ContaCorrente("1212111", 2500.0);
		
		cc.depositaConta(1000);
		
		/*if (!cc.saqueConta(400)) {
			System.out.println("Saque não efetuado.");			
		}*/
		try {
			cc.saqueConta(-500);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (ValorInvalido e) {
			//System.out.println("Valor não pode ser negativo ou igual a zero");
			System.out.println("Erro: " + e.getMessage());
		} catch (SaldoNegativo e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println(cc.toString());
	}
}
