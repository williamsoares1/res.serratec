package atividade1;

import java.util.Scanner;

public class Atividade {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean repetir;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("Insira o primeiro número: ");
			int primeiro = input.nextInt();
			
			System.out.println("Insira o segundo número: ");
			int segundo = input.nextInt();
			
			repetir = !imprimirTabuada(primeiro,segundo);
		} while(repetir);
	}
	public static void tabuada(int num) {
		int i;
		
		for(i = 1; i <= 10; i++) {
			System.out.println(num + " x " + i + " = " + (num * i));
		}
		System.out.println("\n");
	}
	
	public static boolean imprimirTabuada(int inicio, int fim) {
		if(inicio > fim) {
			System.out.println("Valores Inválidos");
			return false;
		}
		
		for(int i = inicio; i <= fim; i++) {
			tabuada(i);
		}
		
		return true;
	}
}
