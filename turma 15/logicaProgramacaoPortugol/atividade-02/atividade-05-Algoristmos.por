/*5. A turma C é composta de 60 alunos, e a turma D de 20 alunos. 
Escreva um algoritmo que leia o percentual de alunos reprovados na turma C, 
o percentual de aprovados na turma D, calcule e escreva:
a) O número de alunos reprovados na turma C.
b) O número de alunos reprovados na turma D.
c) A percentagem de alunos reprovados em relação ao total de alunos das duas turmas
*/
programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro reprovadosC, reprovadosD
		real totalRepC, totalAprD, turmaC = 60, turmaD = 20

		escreva("Informe o numero de alunos reprovados na turma C(max = 60): ")
		leia(reprovadosC)
		escreva("Informe o numero de alunos reprovados na turma D(max = 20): ")
		leia(reprovadosD)

		totalRepC = m.arredondar(((reprovadosC / turmaC) * 100), 2)
		totalAprD = m.arredondar((((turmaD - reprovadosD) / turmaD) * 100),2)

		escreva(totalRepC + "% dos alunos da turma C foram reprovados e " + totalAprD + "% foram aprovados na turma D.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 832; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */