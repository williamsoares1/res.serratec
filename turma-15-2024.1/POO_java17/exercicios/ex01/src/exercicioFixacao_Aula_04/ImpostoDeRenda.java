/*
 * 1) Criar uma classe com o nome ImpostoDeRenda com os seguintes atributos com visibilidade protected.

String (nome, telefone e email)

double (rendimentos)

Insira o construtor com os atributos nome e rendimentos.

Criar uma nova classe com o nome PessoaFisica herdando de ImpostoDeRenda com os seguintes atributos privados:

String (cpf e rg)

Criar uma nova classe com o nome PessoaJuridica herdando de ImpostoDeRenda com os seguintes atributos privados:

String (cnpj e inscEstadual).

Insira o construtor com todos atributos para ambas as classe.

PessoaFisica (nome, rendimentos, cpf e rg )

PessoaJuridica (nome, rendimentos , cnpj e inscEstadual).

Métodos das classes em comum PessoaFisica e PessoaJuridica:

Crie o método calculoIR. Para pessoa física deverá ser calculado o desconto 12% do rendimento e para e pessoa jurídica 15% do valor do
rendimento.

Construa dois objetos em outra classe com o nome TestaIR

Exiba os dados e o valor a pagar de cada tipo de pessoa.
 */

package exercicioFixacao_Aula_04;

public class ImpostoDeRenda {
	protected String nome;
	protected String telefone;
	protected String email;
	protected double rendimentos;

	@Override
	public String toString() {
		return "Nome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email + "\nRendimentos: "
				+ rendimentos + "\n";
	}

	public ImpostoDeRenda(String nome, double rendimentos) {
		super();
		this.nome = nome;
		this.rendimentos = rendimentos;
	}

	public String calculoIR() {
		return String.format("%.2f", rendimentos);
	}

}