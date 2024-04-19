package exercicioFixacao_Aula_03;

import java.util.Scanner;

public class CalculadoraMain {
	final static Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Informe o primeiro numero: ");
		int num1 = INPUT.nextInt();
		System.out.println("Informe o segundo numero: ");
		int num2 = INPUT.nextInt();
		
		System.out.println("1 - soma\n2 - subtracao\n3 - multiplicacao\n4 - divisao\n5 - sair");
		int opc = INPUT.nextInt();
		
		Calculadora calc = new Calculadora();
		String resultado = "Resultado: " + calc.calcular(num1, num2, opc);
		System.out.println(resultado);
	}

}
