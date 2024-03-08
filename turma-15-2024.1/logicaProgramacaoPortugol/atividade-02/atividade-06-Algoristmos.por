/**
 * 6. Um motorista de taxi deseja calcular o rendimento de seu carro na praça. 
 * Sabendo-se que o preço do combustível é de R$ 7,50 por litro, escreva um algoritmo para ler: 
 * a marcação do odômetro (Km) no início do dia, a marcação (Km) no final do dia, 
 * o número de litros de combustível gasto e o valor total (R$) recebido dos passageiros.
 * Calcular e escrever: a média do consumo em Km/L e o lucro (líquido) do dia.
*/

//assumi q o carro ande 8km/L

programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		//varaiveis
		real gasLitro = 7.5, kmAtual, kmInicio = 0.0,  valorRec, valorGasto, valorAtual = 0.0, valorTotalRec, valorTotalGasto
		inteiro opcao, opcao2

		//iniciação
		escreva("Deseja aceitar a corrida? \n=============== \n1 - SIM \n2 - NÃO\n")
		leia(opcao)
		limpa()
		
		logico comecar = verdadeiro
		
		enquanto(comecar){
			escolha(opcao)
			{
				caso 1:
				{
					escreva("Informe a distancia da corrida(km): ")
					leia(kmAtual)
					escreva("Informe o valor da corrida: ")
					leia(valorRec)
					//limpa()

					kmAtual += kmInicio
					valorRec += valorAtual

					kmInicio = kmAtual
					valorAtual = valorRec
					
					valorGasto = m.arredondar((gasLitro / 8), 2)
					valorTotalRec = valorAtual

					
					// loop reiniciação
					escreva("Deseja aceitar mais uma corrida? \n=============== \n1 - SIM \n2 - NÃO / Ver ganho total \n\n")
					leia(opcao2)
					
					se(opcao2 == 1)
					{
						comecar = verdadeiro
						
					}
					senao
					{
						comecar = falso
						valorAtual -= (valorGasto * kmInicio)
						escreva("===============\nServiço encerrado.\n================\n")
						escreva("Você rodou " + kmInicio + "km,\n")
						escreva("e recebeu um valor de R$ " + valorTotalRec + " ao todo")
						escreva("\ncom o gasto de R$ " + valorGasto + " por km em gasolina")
						escreva("\nO ganho total com os gastos foi de " + valorAtual + ".")
					}
					
				}
				caso 2: pare
				caso contrario: pare
			}
			
		}
		
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1219; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */