/**Lista 2 de exercícios:
 * 
 * 1. Desenvolva um algoritmo que receba o salário de um funcionário, 
 * calcule e mostre seu novo salário com reajuste de 15%.
**/
programa
{
  inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		inteiro salario
		real porcentagem = 0.15, reajusteAd, reajusteDef
		
		escreva("Informe o salario (Ex: 3500): ")
		leia(salario)
		limpa()
		
		reajusteAd = m.arredondar(salario * porcentagem,2)
		reajusteDef = m.arredondar(reajusteAd + salario,2)
		escreva("O resjuste salarial de +15% foi de: R$ "  + reajusteAd + "\nO novo salario do funcionario é: R$ " + reajusteDef + ".")

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 469; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */