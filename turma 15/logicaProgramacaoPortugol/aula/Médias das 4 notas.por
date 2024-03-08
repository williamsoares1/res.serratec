/**
 * Crie um programa que leia 4 notas de um aluno.
 * Receba o nome desse aluno e verifique a média das 4 notas.
 * 
 * Se a média for menor ou igual a 5, informe que o aluno está reprovado
 * Se a média for maior que 5 e menor ou igual a 6, informe que o aluno está de recuperação
 * Se a média for maior que 6, informe que o aluno está aprovado
 * 
 */

programa
{
	
	funcao inicio()
	{
		//Declaração de variáveis
		real nota1, nota2, nota3, nota4
		real media
		cadeia aluno

		//Entradas
		escreva("================================\n")
		escreva("      ESCOLA VAI OU RACHA\n")
		escreva("================================\n\n")
		/*escreva("Nome do aluno: ")
		leia(aluno)
		escreva("Informe as notas dos 4 bimestres\n")
		escreva("--------------------------------\n")
		escreva("1º Bimestre: ")
		leia(nota1)
		escreva("2º Bimestre: ")
		leia(nota2)
		escreva("3º Bimestre: ")
		leia(nota3)
		escreva("4º Bimestre: ")
		leia(nota4)*/

		aluno = "Ricardo"

		nota1 = 7.0
		nota2 = 8.0
		nota3 = 9.5
		nota4 = 7.0

		//Processamento
		media = (nota1 + nota2 + nota3 + nota4) / 4

		se (media <= 5) {
			escreva(aluno + " você está reprovado com a média " + media)
		} senao se ((media > 5) e (media <= 6)) {
			escreva(aluno + " você está em recuperação com a média " + media)
		} senao {
			escreva(aluno + " você está aprovado com a média " + media)
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1366; 
 * @PONTOS-DE-PARADA = 46;
 * @SIMBOLOS-INSPECIONADOS = {media, 18, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */