// 1- fazer algoritmo que leia várias notas de alunos. Calcule e imprima a média da turma

programa
{
	
	funcao inicio()
	{
		inteiro i = 1, nrNotas, alunos, opcao,opcao2
		
		logico comecar = verdadeiro

		escreva("Deseja iniciar a soma de medias? \n1 - SIM \n2 - NÃO\n")
		leia(opcao)
		limpa()
		
		enquanto(comecar)
		{
			escolha(opcao)
			{
				caso 1: 
				{	real notaRec, nota = 0.0, notaTotal, media 
					
					escreva("Quantas notas deseja informar? ")
					leia(nrNotas)
	
					alunos = nrNotas
			
					para(i; i <= nrNotas; i++)
					{	
						escreva("informe a nota do " + i + "º aluno: ")
						leia(notaRec)
						nota += notaRec
						notaTotal = nota
						media = notaTotal / nrNotas
						
						se(i == nrNotas)
						{
							escreva("\n\nA media de notas da turma é: " + media + ".")
						}
					}
					comecar = falso
				}
				caso contrario : comecar = falso pare	
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 629; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */