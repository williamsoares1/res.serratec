/*
1) Uma clínica tem necessidade de informar o IMC (Índice de Massa Corporal) dos seus pacientes.
Sabendo que o IMC se calcula da seguinte forma: divide-se o peso (em kg) pelo quadrado da altura (em metros), 
crie um programa que faça o cálculo do IMC de um dado paciente.

Informe o IMC do paciente.
Caso o IMC seja menor que 18,5, informe que a classificação é Baixo peso.
Caso o IMC seja maior que 18,5 e menor que 24,9, informe que a classificação é Peso saudável.
Caso o IMC seja maior ou igual a 25 e menor que 29,9, informe que a classificação é Sobrepeso.
Caso o IMC seja maior ou igual a 30, informe que a classificação é Obesidade.
*/

programa{

	inclua biblioteca Matematica --> m
	inclua biblioteca Texto --> t
	
	
	funcao inicio(){
	
		cadeia nome, nomeCA
		real peso, altura, imc
		
		escreva("Favor insira o nome do paciente: ")
		leia(nome)
		escreva("Insira a altura(m) do paciente: ")
		leia(altura)
		escreva("Insira o peso(kg) do paciente: ")
		leia(peso)

		nomeCA = caixaAlta(nome)
		imc = calcIMC(altura, peso)
		
		escreva("O paciente " + nomeCA + " possui um IMC de " + imc + ".\n")
		escreva(mensagem(nomeCA, imc))
		
	}


	funcao real calcIMC(real altura, real peso){
		real imc
		
		imc = m.arredondar(peso / m.potencia(altura, 2), 1)

		retorne imc
	}


	funcao cadeia mensagem(cadeia nome,real imc){
		cadeia mensagemRetornada

		se(imc < 18.5)
			mensagemRetornada = "O paciente " + nome + " se encaixa na classificação de Baixo peso."
		senao 
			se(imc >= 18.5 e imc <= 24.9)
				mensagemRetornada = "O paciente " + nome + " se encaixa na classificação de Peso saudável."
		senao 
			se(imc >= 25 e imc <= 29.9)
				mensagemRetornada = "O paciente " + nome + " se encaixa na classificação de Sobrepeso."	
		senao
			mensagemRetornada = "O paciente " + nome + " se encaixa na classificação de Obesidade."

		retorne mensagemRetornada
	}

	
	funcao cadeia caixaAlta(cadeia nome){
		cadeia textoTransformado, nome1, nome2

		nome1 = t.extrair_subtexto(nome, 0, 1)
		nome2 = t.extrair_subtexto(nome, 1, t.numero_caracteres(nome))
		textoTransformado = t.caixa_alta(nome1) + nome2
		
		retorne textoTransformado
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 978; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */