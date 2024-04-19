package exercicios;

public class CalculadoraMedia {
	
	private static double nota1, nota2, nota3, nota4, media;	
	
	public static void calcular() {
		nota1 = 8;
		nota2 = 7.5;
		nota3 = 6.9;
		nota4 = 9.8;
		
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		
		System.out.println("A média é "+ media);
	}
	
	
	public static void calcularNaImpressao() {
		nota1 = 8;
		nota2 = 7.5;
		nota3 = 6.9;
		nota4 = 9.8;
		
		System.out.println("A média é "+ ((nota1 + nota2 + nota3 + nota4) / 4));
	}
	
	public static void calcularSalario() {
		String nome = "Ricardo";
		double salario = 2000;
		double salarioLiquido;
		double valorDesconto;
		
		if (salario <= 1751.81) {
			salarioLiquido = salario * 0.92;
			valorDesconto = salario * 0.08;
		} else if (salario <= 2919.72) {
			salarioLiquido = salario * 0.91;
			valorDesconto = salario * 0.09;
		} else if (salario <= 5389.45) {
			salarioLiquido = salario * 0.90;
			valorDesconto = salario * 0.10;
		} else {
			salarioLiquido = salario * 0.89;
			valorDesconto = salario * 0.11;
		}
		
		//valorDesconto = salario - salarioLiquido;
		
		System.out.println("Boa noite, " + nome);
		System.out.println("O seu salário líquido é " + salarioLiquido);
		System.out.println("Salário bruto: "+ salario);
		System.out.println("Valor do desconto: "+ valorDesconto);
		
	}
}
