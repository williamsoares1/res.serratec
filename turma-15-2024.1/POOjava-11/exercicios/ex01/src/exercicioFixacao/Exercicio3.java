//3) A concessionária de veículos “CARANGO” está vendendo os seus veículos com desconto.
//Faça um algoritmo que calcule e exiba o valor do desconto e o valor a ser pago pelo cliente.
//O desconto deverá ser calculado sobre o valor do veículo de acordo com o combustível 
//(álcool – 25%, gasolina – 21% ou diesel –14%).
//Com valor do veículo zero encerra entrada de dados. Informe total de desconto e total pago pelos clientes.
package exercicioFixacao;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
	
	final static Scanner INPUT = new Scanner(System.in);
	final static String LINHA = "--------------------------------------";
	final static NumberFormat NF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	public static void main(String[] args) {
		inicio();
	}
	
	public static void inicio() {
		System.out.println(LINHA);
		System.out.println("Seja bem-vindo na concessionaria");
		System.out.println(LINHA);
		
		System.out.println("Informe o valor do veiculo: ");
		double valor = INPUT.nextDouble();
		
		if(valor < 1) {
			System.out.println("Valor inválido. \nReinicie o programa.");
		}else {
			System.out.println("Informe o tipo de combustivel do veiculo: "
								+ "\n1 - Álcool"
								+ "\n2 - Gasolina"
								+ "\n3 - Diesel"
								+ "\n4 - Nulo");
			
			int opcao = INPUT.nextInt();
			
			concessionaria(valor, opcao);
		}
		
	}
	
	
	public static void concessionaria(double valorVeiculo, int opcao) {
		double tipo = 0;
		
		switch(opcao) {
		
		case 1:
			tipo = 0.25;
			break;
		case 2:
			tipo = 0.21;
			break;
		case 3:
			tipo = 0.14;
			break;
		default:
			break;
		}
		
		String valorDesconto = NF.format(valorVeiculo * tipo);
		String valorPagar = NF.format(valorVeiculo - (valorVeiculo * tipo));
		
		System.out.println(LINHA);
		System.out.println("O desconto foi de " + valorDesconto + ".\nO valor a pagar é de " + valorPagar);
	}
}
