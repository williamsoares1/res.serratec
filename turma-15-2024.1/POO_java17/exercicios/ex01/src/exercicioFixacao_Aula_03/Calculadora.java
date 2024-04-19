/*
 * 3) Crie uma classe com o nome Calculadora. Esta classe deverá conter um método para cálculo das operações básicas e
retornar um valor como double.

3.1)Criar uma classe MainCalculadora com o método main com um menu com 5 opções:

1 – soma

2 – subtração

3 – multiplicação

4 – divisão

5 – sair

Entrar com os dois valores via console ou JOptionPane e exibir o resultado da operação.
 */

package exercicioFixacao_Aula_03;

public class Calculadora {
	public double calcular(int num1, int num2, int opc) {
		double result = 0;
		
		switch(opc) {
			case 1: result = num1 + num2; 
					break;
			
			case 2: result = num1 - num2;
					break;
			
			case 3: result = num1 * num2;
					break;
					
			case 4: result = num1 / num2;
					break;
					
			case 5: System.out.println("Finalizando tarefa...");
					break;
			
			default: break;
		}
		
		return result;
	}

}
