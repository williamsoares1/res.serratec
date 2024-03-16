/**
 * Melhore o código abaixo criando métodos separados para cadastrar o nome e a idade e também 
 * para imprimir os dados.
 * Crie um menu onde se possa selecionar qual opção deseja executar: cadastrar nome / cadastrar idade
 * imprimir dados
 * 
 * Exemplo:
 * 
 * ----------------------
 * 1- Cadastrar nomes
 * 2- Cadastrar idades
 * 3- Imprimir dados
 * 4- Sair
 * ----------------------
 */

programa
{
	const cadeia LINHA = "------------------------------\n"
	const inteiro T = 5
	cadeia vNomes[T]
	inteiro vIdade[T]
	
	funcao inicio()
	{		
		inicializarVetores()
		menu()		
	}

	funcao cadastrarNomes() {

		escreva(LINHA)
		escreva("Cadastro de nomes\n")
		escreva(LINHA)

		para (inteiro i = 0; i < T; i++) {
			se (vNomes[i] == "") {
				escreva("Índice " + i + ": Informe o nome: ")
				leia(vNomes[i])
			}
		}
	}

	funcao cadastrarNomeIdade() {
		logico cadastrou = falso
		
		para (inteiro i = 0; i < T; i++) {
			se (vNomes[i] == "") {
				escreva("Índice " + i + ": Informe o nome: ")
				leia(vNomes[i])
				escreva("Índice " + i + ": Informe a idade: ")
				leia(vIdade[i])
				cadastrou = verdadeiro
				pare
			}			
		}

		se (nao cadastrou) {
			escreva("O vetor está completo.\nNão foi possível cadastrar.")
			aguarde()
		}
	}

	funcao cadastrarIdades() {

		escreva(LINHA)
		escreva("Cadastro de idades\n")
		escreva(LINHA)
		
		para (inteiro i = 0; i < T; i++) {
			escreva("Informe a idade: ")
			leia(vIdade[i])
		}
	}

	funcao cadeia informeNome() {
		cadeia nome
		
		escreva("Informe o nome desejado: ")
		leia(nome)

		retorne nome
	}

	funcao inteiro localizarNomePessoa(cadeia nomePessoa) {
		inteiro indice = -1
		
		para (inteiro i = 0; i < T; i++) {			
			se (vNomes[i] == nomePessoa) {
				 indice = i
				 pare
			}
		}		
		
		retorne indice
	}

	funcao imprimirDados() {	
		
		escreva(LINHA)
		escreva("Dados das pessoas")
		escreva(LINHA)
		escreva("Nr\tNome\tIdade\n")

		para (inteiro i = 0; i < T; i++) {
			
			se (vNomes[i] != "" ou vIdade[i] != -1)
				escreva((i+1) + "\t")
			
			se (vNomes[i] != "")
				escreva(vNomes[i])

			se (vIdade[i] != -1) 
				escreva("\t" + vIdade[i] + "\n")
		}		

		aguarde()
	}

	funcao aguarde() {
		cadeia tecla
		
		escreva("\n\nPressione uma tecla")
		leia(tecla)
	}

	funcao imprimirPessoa(inteiro indice) {
		se (indice >= 0 e indice < T) {
			escreva(LINHA)
			escreva("Dados da pessoa")
			escreva(LINHA)
			escreva("Nr\tNome\tIdade\n")
			escreva(indice+1 +"\t")
			
			se (vNomes[indice] != "")
				escreva(vNomes[indice])
			se (vIdade[indice] != -1) 	
				escreva("\t"+ vIdade[indice])
			
			aguarde()		
		} senao {
			escreva("Nome não encontrado")
			aguarde()
		}
	}

	funcao menu() {
		inteiro opcao		
		
		faca {
			limpa()
			
			escreva(LINHA)
			escreva("Escolha uma opção\n")
			escreva(LINHA)
 			escreva("1- Cadastrar nomes\n")
 			escreva("2- Cadastrar idades\n")
 			escreva("3- Imprimir dados\n")
 			escreva("4- Cadastrar um nome com idade\n")
 			escreva("5- Localizar pessoa\n")
 			escreva("6- Excluir uma pessoa\n")
 			escreva("7- Limpar todos os dados\n")
 			escreva("8- Sair\n")
 			escreva(LINHA)
 			leia(opcao)

 			limpa()

			escolha(opcao) {
				caso 1: cadastrarNomes() pare
				caso 2: cadastrarIdades() pare
				caso 3: imprimirDados() pare
				caso 4: cadastrarNomeIdade() pare
				caso 5: imprimirPessoa(
							localizarNomePessoa(
									informeNome()
							)
					   ) pare
				caso 6: excluirPessoa(LocalizarPessoa()) pare
				caso 7: inicializarVetores() pare
				caso 8: escreva("\nObrigado por utilizar!") pare
				caso contrario: escreva("Opção inválida")
			}
 			
		} enquanto (opcao != 8)		
	}

	funcao excluirPessoa(inteiro indice) {
		vNomes[indice] = ""
		vIdade[indice] = -1
	}

	funcao inteiro LocalizarPessoa() {
		inteiro indice
		
		escreva("Informe o código da pessoa: ")
		leia(indice)
		
		retorne indice -1
	}

	funcao inicializarVetores() {
		para (inteiro i = 0; i < T; i++) {
			vIdade[i] = -1
			vNomes[i] = ""
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 575; 
 * @DOBRAMENTO-CODIGO = [29, 43, 63, 75, 84, 119];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */