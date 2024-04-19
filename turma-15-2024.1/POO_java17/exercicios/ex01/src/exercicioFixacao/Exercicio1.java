/*
1) Escreva um algoritmo que leia 2 números e imprima o resultado deles (um pelo outro) com as expressões aritméticas: divisão, multiplicação, soma e subtração.
Pergunte antes, o nome do usuário, dê as boas vindas e informe o resultado das expressões.
 */

package exercicioFixacao;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercicio1 {

	public final static Scanner INPUT = new Scanner(System.in);
	final static String LINHA = "--------------------------------------";
	public final static DecimalFormat DF = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		mensagem();
		System.out.println(LINHA);
		expressoesA();
		}
	
	public static void mensagem() {
		System.out.println("Informe seu nome: ");
		String nome = INPUT.next();
		System.out.println(LINHA);
		System.out.println("Bem-vindo " + nome + "!!!");
	}
	
	public static void expressoesA() {
		System.out.println("Favor informe um numero: ");
		int num1 = INPUT.nextInt();
		System.out.println("Mais um numero: ");
		int num2 = INPUT.nextInt();
		System.out.println("Resultados: ");
		
		System.out.println(LINHA);
		
		System.out.println(num1 + " / " + num2 + " = " + (DF.format((float) num1 / num2)) + "\n");
		System.out.println(num1 + " x " + num2 + " = " + (num1 * num2) + "\n");
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2) + "\n");
	}

}
