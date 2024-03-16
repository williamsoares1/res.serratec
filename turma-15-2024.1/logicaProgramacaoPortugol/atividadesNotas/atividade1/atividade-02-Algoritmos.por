/*
 2) Uma contabilidade precisa calcular o Imposto de Renda dos funcionários de uma empresa.
Dada a tabela do Imposto de Renda abaixo, solicite o salário de um funcionário e calcule o valor do imposto de renda a pagar, 
tendo efetuado a dedução e informe para o contador o valor da base de cálculo,
a alíquota aplicada, o valor deduzido e o imposto a pagar.
Obs.: A parcela a deduzir deve ser multiplicada pelo número de dependentes.

IR na fonte
--------------------------------------------------------------------------------------
Base de cálculo¹ (R$)		Alíquotas em %		Parcela a deduzir do IR (R$)
--------------------------------------------------------------------------------------
Até 2.112,00			0,00			0,00
De 2.112,01 até 2.826,65	7,50			158,40
De 2.826,66 até 3.751,05	15,00			370,40
De 3.751,06 até 4.664,68	22,50			651,73
Acima de 4.664,68		27,50			884,96

Exemplo:

Entrada:

Salário: R$ 3.500,00
Número de dependentes: 1

Processamento:

(3.500 * 0,15) - (370,40 *1) = 154,60

Saída:

Base de Cálculo: R$ 3.500,00
Alíquota IR: 15,00%
Parcela a deduzir: R$ 370,40
Imposto a pagar: R$ 154,60

Obs.: Caso o valor do imposto seja negativo, apresentar valor a pagar igual a zero.
Obs2.: O exercício acima é apenas para treinamento e não representa o cálculo do imposto oficial.
*/
programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro nrDependentes
		real salario, nrParcela, nrAliquota, imposto

		escreva("Informe o salario: ")
		leia(salario)
		escreva("Informe o numero de dependentes: ")
		leia(nrDependentes)
		limpa()
		
		se(salario <= 2112.0){
			nrParcela = 0.00
			nrAliquota = 0.0
		}senao se(salario <= 2826.65){
			nrParcela = 158.40
			nrAliquota = 0.075
		}senao se(salario <= 3751.05){
			nrParcela = 370.40
			nrAliquota = 0.15
		}senao se(salario <= 4664.68){
			nrParcela = 651.73
			nrAliquota = 0.225
		}senao{
			nrParcela = 884.96
			nrAliquota = 0.275
		}
			
		imposto = m.arredondar(((salario * nrAliquota) - (nrParcela * nrDependentes)), 2)
		
		se(imposto < 0){
			imposto = 0.0
			escreva("O funcionario não possui valor a pagar.")
		}senao{
			escreva("\nBase de Cálculo:  R$ " + salario + ".")
			escreva("\n\nAlíquota IR: " + nrAliquota * 100 + "%" + ".")
			escreva("\n\nParcela a deduzir:  R$ " + nrParcela + " x "+ nrDependentes + ".")
			escreva("\n\nImposto a pagar: R$ " + imposto + ".\n")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2132; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */