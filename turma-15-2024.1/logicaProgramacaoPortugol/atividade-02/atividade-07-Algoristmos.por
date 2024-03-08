/**
 * 7- Crie um programa “termômetro” que lê uma temperatura em graus celsius, 
 * e devolve sua equivalência na escala fahrenheit. (Use: F = C * 1,8 + 32)

Exemplo:
Temperatura em °C: 30°
Temperatura em °F: 86°
 */

programa
{
	
	funcao inicio()
	{
		real nrCelsius, nrFahrenheit
		
		escreva("Informe a temperatura em celsius: ")
		leia(nrCelsius)
		limpa()

		nrFahrenheit = nrCelsius * 1.8 + 32

		escreva("Temperatura em °C: " + nrCelsius + "° .")
		escreva("\nTemperatura em °F: " + nrFahrenheit + "° .\n")
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 517; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */