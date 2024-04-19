programa
{
	const inteiro t = 2
	inteiro idades[t]
	cadeia nomes[t]
	
	funcao inicio()
	{		
		hub()
	}

	funcao cadNomes()
	{
		para(inteiro i = 0;i < t ;i++)
		{
			se(nomes[i] == "")
			{
				escreva("Informe o " + (i + 1) + "º nome:  \n")
				leia(nomes[i])
			}
		}
		limpa()
	}

	funcao cadIdades()
	{
		para(inteiro i = 0;i < t ;i++)
		{
			escreva("Informe a " + (i + 1) + "ª idade: \n")
			leia(idades[i]) 
		}
		limpa()
	}

	funcao impDados()
	{	
		escreva("NOME\tIDADE\n")
		
		para(inteiro i = 0;i<t;i++)
		{	
			escreva(nomes[i] + "\t" + idades[i] + "\n")
		}
	}

	funcao hub()
	{
		inteiro opcao
	
		faca
		{
			escreva("1 - Cadastrar nomes\n2 - Cadastrar idades\n3 - Imprimir dados\n4 - Cadastrar nome e idade\n")
			escreva("\n5 - Localizar pessoa\n6 - Cadastrar idades\n7 - Imprimir dados\n8 - Cadastrar nome e idade\n")
			//escreva("\n9 - Cadastrar nomes\n10 - Cadastrar idades\n11 - Imprimir dados\n12 - Cadastrar nome e idade\n")
			leia(opcao)
		
			escolha(opcao)
			{
			caso 1: cadNomes() pare
			caso 2: cadIdades() pare
			caso 3: impDados() pare
			caso 4: cadNomeIdade() pare
			caso 5: locPessoa() pare
			caso contrario : pare
			}
		}enquanto(opcao != 6)
	}

	funcao cadNomeIdade()
	{
		para(inteiro i = 0;i < t ;i++)
		{
			se((nomes[i] == "")ou(idades[i] < 0))
				escreva("Informe o " + (i + 1) + "º nome:  \n")
				leia(nomes[i])
				escreva("Informe o " + (i + 1) + "ª idade:  \n")
				leia(idades[i])
		}
	}

	funcao locPessoa()
	{
		escreva("Informe o nome da pessoa buscada")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1512; 
 * @DOBRAMENTO-CODIGO = [6, 11, 24, 38, 34, 67];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */