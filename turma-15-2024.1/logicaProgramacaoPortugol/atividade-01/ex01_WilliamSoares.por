// Execicio 1: Crie um programa que leia 3 números do usuário, faça a soma e informe ao usuário o resultado final.

programa {
  funcao inicio() {

    inteiro primeiroNumero, segundoNumero, terceiroNumero, soma

    escreva("Favor informe um número: ") 
    leia(primeiroNumero)
    escreva("Insira mais um número: ")
    leia(segundoNumero)
    escreva("Só mais um: ")
    leia(terceiroNumero)

    soma = primeiroNumero + segundoNumero + terceiroNumero

    escreva("A soma dos números digitados é: " + soma)
  }
}
