// 3) Crie um algoritmo que solicite o dia, o mês e o ano e informe se a data é válida ou inválida.
// Considere o mês de fevereiro com 28 dias.

programa
{	
	funcao inicio()
	{
		logico data
		inteiro dia, mes, ano, fev

		escreva("Dia: ")
		leia(dia)
		escreva("Mes: ")
		leia(mes)
		escreva("Ano: ")
		leia(ano)

		fev = ano % 4
		
		se(fev == 0)
			fev = 29
		senao
			fev = 28

		
		se(ano <= 0)
			data = falso	
		senao{

			se((dia >= 1 e dia <= 31) e (mes == 1 ou mes == 3 ou mes == 5 ou mes == 7 ou mes == 8 ou mes == 10 ou mes == 12))
			data = verdadeiro
		senao se((dia >= 1 e dia <= 30) e (mes == 4 ou mes == 6 ou mes == 9 ou mes == 11))
			data = verdadeiro
		senao se((dia >= 1 e dia <= fev) e (mes == 2))
			data = verdadeiro
		senao
			data = falso
			}

		se(data)
			escreva("A data " + dia + "/" + mes + "/" + ano + " é válida.")
		senao
			escreva("A data " + dia + "/" + mes + "/" + ano + " é inválida.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 771; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */