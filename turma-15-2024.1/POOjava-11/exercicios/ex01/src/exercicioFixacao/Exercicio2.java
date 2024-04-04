/*
 2) Fazer algoritmo que leia várias notas de alunos. Calcule e imprima a média da turma
 */

package exercicioFixacao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio2 {
	
	public final static Scanner INPUT = new Scanner(System.in);
	public final static DecimalFormat DF = new DecimalFormat("0.0");
	public final static String LINHA = "--------------------------------------";

	public static void main(String[] args) {
		calcularMedia();
	}
	
	public static void calcularMedia() {
		System.out.println("Quantas notas deseja informar? ");
		int qtdNotas = INPUT.nextInt(), i;
		System.out.println(LINHA);

		float nota = 0;
		
		for(i = 1; i <= qtdNotas; i++) {
			System.out.println("Insira a " + i + "ª nota: ");
			nota += INPUT.nextFloat();
			
			if(i == qtdNotas) {
				String notaF = DF.format(nota / qtdNotas);
				System.out.println(LINHA);
				System.out.println("A média de notas da turma é: " + notaF);
			}
		}
	}
}
