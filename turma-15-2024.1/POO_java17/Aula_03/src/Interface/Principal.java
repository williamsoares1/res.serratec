package Interface;

import java.util.Scanner;

import classes.Medico;
import classes.Pessoa;
import classes.Produto;

public class Principal {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		exemploMedico();
	}
	
	public static void exemploMedico() {
		Medico ana = new Medico("123456", "Ana Maria", 0, 250);
		Medico antonio = new Medico("654321", "Antonio", 0, 300);
		
		for(int i = 1; i <= 8; i++) {
			ana.pagamentoPlano();
			antonio.pagamentoPlano();
			ana.pagamentoDinheiro(25);
			antonio.pagamentoDinheiro(15);
		}
		
		for(int i = 1; i <= 15; i++) {
			antonio.pagamentoDinheiro();
			ana.pagamentoDinheiro();
		}
		
		System.out.println("-------------------------------");
		System.out.println("Total de médicos: " + Medico.getTotalMedicos());
		System.out.println("-------------------------------");
		System.out.println("Consulta " + ana.getNome());
		System.out.println("-------------------------------");
		System.out.println("Valor em dinheiro: " + ana.getTotalDinheiro());
		System.out.println("Valor plano: " + ana.getTotalPlano());
		System.out.println("Valor salário: " + ana.getSalario());
		System.out.println("Total de consultas: " + ana.getTotalConsultas());
		
		System.out.println("\n-------------------------------");
		System.out.println("Consulta " + antonio.getNome());
		System.out.println("-------------------------------");
		System.out.println("Valor em dinheiro: " + antonio.getTotalDinheiro());
		System.out.println("Valor plano: " + antonio.getTotalPlano());
		System.out.println("Valor salário: " + antonio.getSalario());
		System.out.println("Total de consultas: " + antonio.getTotalConsultas());
		
	}
	
 	public static void exemplo1() {
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		
		System.out.println("Informe o nome do produto: ");
		String nmProduto = input.nextLine();
		
		Produto prod1 = new Produto(nmProduto, 10, 1);
		Produto prod2 = new Produto("Feijão", 15, 2);
		Produto prod3 = new Produto();
		
		Produto prod4 = new Produto("Farinha");
		Produto prod5 = new Produto(50);
		
		prod1.calcular();
		prod1.calcular(0);
		
		String var = "Um texto";

		
		System.out.println("Total de produtos: " + Produto.getTotalProdutos());
		
		/*
		p1.setNome("Ricardo");
		p1.setAltura(1.66f);
		p1.setPeso(81f);
		
		p2.setNome("Danilo");
		p2.setAltura(-1.81f);
		p2.setPeso(-72);
		
		
		System.out.println(p1.getObservacao());
		System.out.println("IMC de " + p1.getNome() + " é " + p1.resultado());
		System.out.println("IMC de " + p2.getNome() + " é " + p2.resultado());	
		System.out.println(p1.getImc());
		*/
	}

}
