//3. Desenvolva um algoritmo que receba um valor numérico inteiro, 
//calcule e mostre qual o quociente e o resto da divisão desse número por 3.

programa
{
	
	funcao inicio()
	{
		inteiro num
		
		escreva("Informe um numero: ")
		leia(num)
		
		inteiro calcQuo = num / 3, calcRes = num % 3
		
		escreva(num + " / 3 = " + calcQuo + "\nO resto da divisão de " + num + " / 3 é " + calcRes)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 392; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */