programa
{
	
	funcao inicio()
	{
		real numero
		real vl_percentual_menos, vl_percentual_mais
		
		escreva("Informe um número: ")
		leia(numero)

		vl_percentual_menos = numero * 0.155
		vl_percentual_mais = numero * 1.50

		escreva("\n15,5% porcento de " + numero + " é " + vl_percentual_menos)
		escreva("\n15,5% porcento de 100 é 15,5")
		escreva("\n50% sobre " + numero + " é " + vl_percentual_mais)

		/*
          0    x 100 =   0 --- -100%

          0.99 x 100 =  99 --- -1%
		1    x 100 = 100 --- 0%
          1.01 x 100 = 101 --- 1%
          1.02 x 100 = 102 --- 2%
		1.30 x 100 = 130 --- 30%
		1.50 x 100 = 150 --- 50%    
		2    x 100 = 200 --- 100%
		3    x 100 = 300 --- 200%
		*/
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 150; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */