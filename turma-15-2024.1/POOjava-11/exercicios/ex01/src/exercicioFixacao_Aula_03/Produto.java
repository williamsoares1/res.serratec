/*
 * 2) Criar uma classe com nome Produto com os atributos abaixo:

descricao

valor

quantidade

Encapsular os atributos.

Inserir o construtor com todos os atributos.

Criar um método com o nome calcularIcms. Este método deverá retornar um double sobre 12% do total.

Criar uma classe com o método main

Instanciar os produtos até a resposta digitada for igual a ‘S’ conforme imagem abaixo.
 */

package exercicioFixacao_Aula_03;

public class Produto {
	private String descricao;
	private double valor;
	private int qtd;
	
	public Produto(String descricao, double valor, int qtd) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
	}
	
	@Override
	public String toString() {
		return "Produto: " + descricao + "\nValor: " + valor + "\nQuantidade: " + qtd + "\nValor total: " + (valor * qtd) + "\nICMS: " + calcularIcms() + "\n";
	}

	public double calcularIcms() {
		return (valor * qtd) * 0.12;
	}
	
	
}
