/*
	9) Faça um programa que peça o nome de 10 pessoas e a sua idade.
	Armazene os nomes num vetor e a idade em outro vetor.
	Crie um laço para fazer essas soliciações.
	Crie um menu que permita ao usuário deicidir se quer incluir, alterar ou excluir os dados dos vetores.
	Excluir significa limpar os dados (colocar vazio ou zero).
	A edição somente será permitida se o nome não estiver vazio. Nesse caso, deverá efetuar a inclusão.
	Crie um menu para organizar as funções.
	
	Exemplo:
	
	--------------------------------
	      Cadastro de pessoas
	--------------------------------
	 1 - Incluir
	 2 - Alterar
	 3 - Excluir
	 4 - Sair
	--------------------------------
*/
programa
{	
	inclua biblioteca Texto --> tx
	inclua biblioteca Tipos --> ty
	
	const inteiro t = 2
	cadeia nomes[t], idades[t]
	inteiro i, nrIdades
	
	funcao inicio()
	{
		incluirDados()
		hub()
	}
	
	funcao hub()
	{	
		inteiro opcao

		faca
		{
			escreva("1 - Incluir novos dados\n2 - Alterar\n3 - Excluir\n4 - Mostrar dados\n5 - Sair\n")
			leia(opcao)
			
			escolha(opcao)
			{
				caso 1: incluirDados() pare
				caso 2: altOUdel(verificarDados(), 1) pare
				caso 3: altOUdel(verificarDados(), 2) pare
				caso 4: mostrarDados() pare
				caso contrario: pare
			}
		}enquanto(opcao != 5)
	}

	funcao incluirDados()
	{	
		limpa()
		
		para(i = 0; i < t; i++)
		{
			escreva("Informe o " + (i + 1) + "º nome: ")
			leia(nomes[i])
			nomes[i] = toUpperCase(nomes[i])
			escreva("Informe a idade do " + nomes[i] + ": ")
			leia(idades[i])
			idades[i] = verificarValor(idades[i])
		}
		aguarde()
		
	}

	funcao aguarde()
	{	
		cadeia tecla
		escreva("Pressione uma tecla para continuar: ")
		leia(tecla)
		limpa()
	}

	funcao cadeia toUpperCase(cadeia txt)
	{	
		inteiro length = tx.numero_caracteres(txt)
		cadeia flT = tx.caixa_alta(tx.extrair_subtexto(txt, 0, 1)) + tx.extrair_subtexto(txt, 1, length)

		retorne flT
	}

	funcao cadeia verificarValor(cadeia num)
	{	
		se(ty.cadeia_e_inteiro(num, 10))
			{
				nrIdades = ty.cadeia_para_inteiro(num, 10)
				
				se(nrIdades < 0)
				{
					escreva("Valor invalido - Informe outro numero: ")
					leia(num)
					retorne verificarValor(num)
				}senao
					retorne num
			}
		senao
		{
			escreva("Valor invalido - Informe outro numero: ")
			leia(num)
			retorne verificarValor(num)
		}
	}

	funcao inteiro verificarDados()
	{
		logico encontrou = falso
		inteiro indice = 0
		
		enquanto(nao encontrou)
		{
			para(i = 0; i<t; i++)
			{
				escreva(nomes[i] + " - " + idades[i] + " anos.\n")
			}
			
			cadeia info
			escreva("Informe o nome referente aos dados a serem alterados: ")
			leia(info)
			
			info = toUpperCase(info)
			
			para(i = 0; i < t; i++)
			{	
				se(nomes[i] == info)
				{	
					escreva("Nome encontrado na posição do vetor " + i + "\n")
					encontrou = verdadeiro
					indice = i
					pare
				}
			}
		}
		retorne indice
	}

	funcao altOUdel(inteiro indice, inteiro opcaoInf)
	{
		inteiro opcao2
		
		escreva("Qual dado deseja alterar/excluir ?\n1 - Nome\n2 - Idade\n3 - Nome e idade\n4 - Sair\n")
		leia(opcao2)
		
		escolha(opcaoInf)
		{
			caso 1:
			{		
				se(opcao2 == 1)
				{
					escreva("Informe o novo nome: ")
					leia(nomes[indice])
					nomes[indice] = toUpperCase(nomes[indice])
					escreva("Alteração completa.")
				}
				senao se(opcao2 == 2)
				{
					escreva("Informe a nova idade: ")
					leia(idades[indice])
					escreva("Alteração completa.")
				}
				senao se(opcao2 == 3)
				{
					escreva("Informe o novo nome: ")
					leia(nomes[indice])	
					nomes[indice] = toUpperCase(nomes[indice])
					escreva("Informe a nova idade: ")
					leia(idades[indice])
					escreva("Alteração completa.")
				}
				senao pare

				pare
			}
			
			caso 2:
			{
				se(opcao2 == 1)
				{
					nomes[indice] = ""
					escreva("Exclusão completa.")
				}
				senao se(opcao2 == 2)
				{
					idades[indice]	= ""
					escreva("Exclusão completa.")
				}
				senao se(opcao2 == 3)
				{
					nomes[indice] = ""
					idades[indice] = ""
					escreva("Exclusão completa.")
				}
				senao pare

				pare
			}
		}
	}

	funcao mostrarDados()
	{
		para(i = 0; i<t; i++)
		{
			escreva(nomes[i] + " - " + idades[i] + " anos.\n")
		}

		aguarde()
	}
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2470; 
 * @DOBRAMENTO-CODIGO = [35, 55, 72, 80, 88, 142, 205];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */