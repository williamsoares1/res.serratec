/* 4. Desenvolva um algoritmo que receba uma quantidade de um alimento em quilos, 
 * calcule e mostre quantos dias durará esse alimento  
 * para uma pessoa que consome 50 gramas desse alimento por dia.
*/
programa
{
	
	funcao inicio()
	{
		inteiro vlG, consumo = 50
		real vlKG
		
		escreva("Informe a quantidade de alimentos(KG): ")
		leia(vlKG)
		limpa()
		
		vlG = vlKG * 1000
		consumo = vlG / consumo

		escreva(vlKG + "KG de alimentos dura um total de " + consumo + " dia(s) se consumido por uma só pessoa.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 279; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */