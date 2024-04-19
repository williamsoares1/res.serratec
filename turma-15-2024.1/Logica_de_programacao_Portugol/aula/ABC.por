/*
 * Crie um algoritmo que:
 * Solicite três números: A, B e C
 * Informe se a soma de A e B é menor que C
 * Informe a média de A, B e C
 * Informe se a soma de B e C é maior que A
 * Informe se A = C
 */
programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		inteiro A, B, C, Soma
		real Media
		real Resultado
		
		escreva("Informe o número A: ")
		leia(A)
		escreva("Informe o número B: ")
		leia(B)
		escreva("Informe o número C: ")
		leia(C)
	

		Soma = A + B
		se (Soma < C) {
			escreva("\nA soma de A + B é menor que C")
		} senao {
			escreva("\nA soma de A + B é maior ou igual a C")
		}

		//Operadores Relacionais
		/*
		 *   >   ---> maior que
		 *   <   ---> menor que
		 *   >=  ---> maior ou igual a
		 *   <=  ---> menor ou igual a
		 *   !=  ---> diferente de
		 *   ==  ---> igual a
		 *   
		 */
		
		
		/*
		se () {
			
		}
		*/
		

		Soma = B + C
		se (Soma > A){
			escreva("\nA soma de B + C é maior que A")
		} senao {
			escreva("\nA soma de B + C é menor ou igual a A")
		}

		Media = (A + B + C) / 3		
		escreva("\nA média de A + B + C é ", mat.arredondar(Media, 2))
		
		se (A == C){
			escreva("\nA é igual a C\n")
		} senao {
			escreva("\nA é diferente de C\n")
		}

		// comentário adicionado
		// Novo comentário
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 926; 
 * @PONTOS-DE-PARADA = 16, 53;
 * @SIMBOLOS-INSPECIONADOS = {A, 15, 10, 1}-{B, 15, 13, 1}-{C, 15, 16, 1}-{Soma, 15, 19, 4}-{Media, 16, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */