programa
{
	
	inclua biblioteca Graficos --> g
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		const inteiro tamanhoX = 900, tamanhoY = 600
		inteiro num1, num2, num3, soma, menor, maior
		cadeia textos, textoMenor, textoMaior
		
		escreva("Informe três números: ")
    		leia(num1, num2, num3)

		soma = num1 + num2 + num3
		
		maior = m.maior_numero((m.maior_numero(num1, num2)), num3)
		menor = m.menor_numero((m.menor_numero(num1, num2)), num3)
		
		textos = "A soma dos numeros selecionados é: " + soma + "."
		textoMenor = "O menor numero digitado é: " + menor + "."
    		textoMaior = "O maior numero digitado é: " + maior + "."
    		
		escreva(textos + "\n" + textoMenor + "\n" + textoMaior)

		logico condicao = verdadeiro
		
		g.iniciar_modo_grafico(condicao)
		g.definir_dimensoes_janela(tamanhoX, tamanhoY)
		g.definir_titulo_janela("Soma dos três numeros.")
		
		enquanto(condicao){
		//estilo texto
		g.definir_cor(g.COR_VERDE)
		g.desenhar_texto(10, 10, textos)
      	g.desenhar_texto(10, 28, textoMenor)
      	g.desenhar_texto(10, 46, textoMaior)
		g.definir_tamanho_texto(16)
		g.definir_estilo_texto(falso, verdadeiro, falso)			
		g.renderizar()

		//bg-color janela
		g.definir_cor(g.COR_PRETO)			
		g.limpar()
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1244; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */