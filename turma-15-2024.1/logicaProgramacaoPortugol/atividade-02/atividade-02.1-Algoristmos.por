//2.1. Desenvolva um algoritmo que receba o valor de um depósito em poupança, 
//calcule e mostre o valor após um determinado número de meses de aplicação 
//na poupança, sabendo que a poupança rende 5% de juros compostos ao mês.
programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro valorRec, mes, i
		real porcentagem = 0.05, valorTotal, valorAd

		escreva("Informe o valor de deposito: ")
		leia(valorRec)
		escreva("Informe o numero de meses para aplicação: ")
		leia(mes)
		limpa()

		valorAd = valorRec * porcentagem
		valorTotal = valorRec

		para(i = 1; i <= mes; i++){
			valorTotal = m.arredondar(valorTotal + valorAd, 2)
			valorAd = valorTotal * porcentagem
			escreva("O valor na poupança é de: R$ " + valorTotal + " com " + i + " mes(s) de aplicação.\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 571; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */