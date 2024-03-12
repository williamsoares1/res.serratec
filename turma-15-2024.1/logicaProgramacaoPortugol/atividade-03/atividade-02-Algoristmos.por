/*
2- A concessionária de veículos “CARANGO” está vendendo os seus veículos com desconto. 
Faça um algoritmo que calcule e exiba o valor do desconto e o valor a ser pago pelo cliente.
O desconto deverá ser calculado sobre o valor do veículo de acordo com o combustível
(álcool – 25%, gasolina – 21% ou diesel –14%). 
Com valor do veículo zero encerra entrada de dados. 
Informe total de desconto e total pago pelos clientes.
*/
programa
{
	inclua biblioteca Matematica --> m
	
	funcao inicio()
	{
		real alcool = 25, gasolina = 21, diesel = 14, vlCarro, desconto
		inteiro opcao

		escreva("Informe o valor do veículo: ")
		leia(vlCarro)
		

	se(vlCarro <= 0)
	{
		escreva("Valor invalido.")
	}
	senao
	{	
		escreva("\nInforme o tipo de combustivel do veiculo: \n1 - álcool\n2 - gasolina\n3 - diesel\n4 - fechar programa.\n")
		leia(opcao)
		
		escolha(opcao)
		{
			caso 1: 
				desconto = vlCarro * (alcool / 100)
				vlCarro -= desconto
				escreva("O valor a ser pago no veiculo é de R$ " + m.arredondar(vlCarro , 2) + " com o desconto de " + alcool + "%.")
				pare
			caso 2: 
				desconto = vlCarro * (gasolina / 100)
				vlCarro -= desconto
				escreva("O valor a ser pago no veiculo é de R$ " + m.arredondar(vlCarro , 2) + " com o desconto de " + gasolina + "%.") 
				pare
			caso 3: 
				desconto = vlCarro * (diesel / 100)
				vlCarro -= desconto
				escreva("O valor a ser pago no veiculo é de R$ " + m.arredondar(vlCarro , 2) + " com o desconto de " + alcool + "%.")
				 pare
			caso contrario: pare
		}
	}
}}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 662; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */