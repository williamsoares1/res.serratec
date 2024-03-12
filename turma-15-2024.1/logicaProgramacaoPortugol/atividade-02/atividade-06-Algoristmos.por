/**
 * 6. Um motorista de taxi deseja calcular o rendimento de seu carro na praça. 
 * Sabendo-se que o preço do combustível é de R$ 7,50 por litro, escreva um algoritmo para ler: 
 * a marcação do odômetro (Km) no início do dia, a marcação (Km) no final do dia, 
 * o número de litros de combustível gasto e o valor total (R$) recebido dos passageiros.
 * Calcular e escrever: a média do consumo em Km/L e o lucro (líquido) do dia.
*/

programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		real precoGas = 7.5, numGas, kmFinal, kmInicio,  valorRec, valorGasto, valorDes, mediaKM
		inteiro opcao, opcao2

		escreva("Informe a marcação (km) do inicio do dia: ")
		leia(kmInicio)
		escreva("Informe a marcação (km) do final do dia: ")
		leia(kmFinal)
		escreva("Informe o número de litros de combustível gasto: ")
		leia(numGas)
		escreva("Informe o valor total recebido dos passageiros: ")
		leia(valorRec)

		kmFinal -= kmInicio
		mediaKM = kmFinal / numGas
		valorGasto = valorRec - (numGas * precoGas)

		escreva("O lucro do dia foi de R$ " + valorGasto + ".\nA media de km/L foi de " + mediaKM + ".")
		
	}


}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1096; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */