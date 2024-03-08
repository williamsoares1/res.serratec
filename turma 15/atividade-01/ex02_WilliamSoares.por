// crie um programa que leia 4 notas de um aluno
// receba o nome desse aluno e verifique a média das 4 notas

programa {

  inclua biblioteca Matematica --> mat

  funcao inicio() {
    
    caracter aluno
    real nota1, nota2, nota3, nota4, media

    escreva("Informe o nome e as 4 notas do aluno: ")
    leia(aluno, nota1, nota2, nota3, nota4)

    media = mat.arredondar(((nota1 + nota2 + nota3 + nota4) / 4), 1)
    
    se(media <= 5){
      escreva("O aluno " + aluno + " está reprovado. \nA média do aluno é " + media + ".")
    }senao se(media > 5 e media < 6){
      escreva("O aluno " + aluno + " está de recuperação. \nA média do aluno é " + media + ".")
    }senao{
      escreva("O aluno " + aluno + " está aprovado.\nA média do aluno é " + media + ".")
    }

  }
}
