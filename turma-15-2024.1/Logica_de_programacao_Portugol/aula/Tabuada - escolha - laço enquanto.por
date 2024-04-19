programa
{
	
	funcao inicio()
	{
		const inteiro NR_VEZES = 10
		inteiro numero, opcao
		inteiro contador = 1
		const cadeia LINHA = "----------------------------\n"
		const cadeia LINHA_DUPLA = "=========================="
		cadeia tecla

		escreva(LINHA)
		escreva("        TABUADA\n")
		escreva(LINHA)

		escreva("Informe um número: ")
		leia(numero)

		escreva("\nInforme o tipo de tabuada:\n")
		escreva("1- Multiplicação\n2- Soma\n3- Sair\n")
		leia(opcao)

		enquanto (opcao != 3) {
			escolha(opcao) {
				caso 1: 
				{
					contador = 1
					enquanto (contador <= NR_VEZES) {
						escreva("\n" + numero + " x " + contador + " = " + (numero * contador))
						contador++	
					}
					pare
				}
				caso 2:
				{
					contador = 1
					enquanto (contador <= NR_VEZES) {
						escreva("\n" + numero + " + " + contador + " = " + (numero + contador))
						contador++	
					}
					pare
				}
				caso contrario: escreva("Opção inválida.\n")		
			}

			escreva("\nENTER para continuar")
			leia(tecla)
			limpa()
			
			escreva(LINHA)
			escreva("        TABUADA\n")
			escreva(LINHA)

			escreva("\nInforme o tipo de tabuada:\n")
			escreva("1- Multiplicação\n2- Soma\n3- Sair\n")
			leia(opcao)			
		}

		escreva("\n\nObrigado por utilizar a calculadora!\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1208; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */