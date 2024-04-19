//Operador ternário
//
//Crie o seguinte código em Java:
//
//1. Crie uma função que retorne o nome do mês a partir de um argumento inteiro que representa o número do mês.
//Exemplo: int semana = 2; 
//semana representa "Fevereiro"
//
//2. Crie uma função que retorne o dia da semana a partir de um argumento inteiro que representa o dia da semana.
//Exemplo: int diaSemana = 5;
//diaSemana representa quinta, onde o primeiro dia é domingo e o último é sábado.
//
//3. Crie um menu que pergunte ao usuário se deseja ver o mês ou a semana.
//
//4. A partir da resposta do usuário, execute uma função do mês ou a função da semana.
//
//5. Imprima na tela o resultado da escolha do usuário que estará armazenada numa variável que recebeu a atribuição por um operador ternário.
//
//Exemplo:
//
//String resposta = (opcao == 1)? funcaoMes(): funcaoSemana();

package exercicioNota_1;

import java.util.Scanner;

public class Exercicio {
	final static Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		inicio();
	}
	
	public static void inicio(){
		System.out.println("Informe um numero: \n1 - Ver mês \n2 - Ver semana \n3 - Sair");
		int opc = INPUT.nextInt();
		
		String resposta = (opc == 1)? retornaMes() :
						  (opc == 2)? retornaSemana() : "Fim do programa...";
		
		System.out.println(resposta);
	}
	
	public static String retornaMes() {
		System.out.println("Informe um numero de 1 a 12: ");
		int opc = INPUT.nextInt();
		
		String mes = (opc == 1) ? "Janeiro" :
					 (opc == 2) ? "Fevereiro":
					 (opc == 3) ? "Março":
					 (opc == 4) ? "Abril":
					 (opc == 5) ? "Maio":
					 (opc == 6) ? "Junho":
					 (opc == 7) ? "Julho":
					 (opc == 8) ? "Agosto":
					 (opc == 9) ? "Setembro":
					 (opc == 10) ? "Outubro":
					 (opc == 11) ? "Novembro":
					 (opc == 12) ? "Dezembro" : "Invalido";
				
		return "O mês referente ao numero informado é: " + mes + ".";
	}
	
	public static String retornaSemana() {
		System.out.println("Informe um numero de 1 a 7: ");
		int opc = INPUT.nextInt();
		
		String semana = (opc == 1) ? "Domingo" :
						(opc == 2) ? "Segunda-feira":
						(opc == 3) ? "Terça-feira":
						(opc == 4) ? "Quarta-feira":
						(opc == 5) ? "Quinta-feira":
						(opc == 6) ? "Sexta-feira":
						(opc == 7) ? "Sábado": "Invalido";
		
		return "O dia da semana referente ao numero informado é: " + semana + ".";
	}

}
