// Execicio 1: Crie um programa que leia 3 n�meros do usu�rio, fa�a a soma e informe ao usu�rio o resultado final.

programa {
  funcao inicio() {

    inteiro primeiroNumero, segundoNumero, terceiroNumero, soma

    escreva("Favor informe um n�mero: ") 
    leia(primeiroNumero)
    escreva("Insira mais um n�mero: ")
    leia(segundoNumero)
    escreva("S� mais um: ")
    leia(terceiroNumero)

    soma = primeiroNumero + segundoNumero + terceiroNumero

    escreva("A soma dos n�meros digitados �: " + soma)
  }
}
