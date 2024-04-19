/*
1) Criar uma classe com nome Funcionario com os seguintes atributos:

nome

salario

Encapsular os atributos.

Inserir o construtor com todos os atributos.

Criar um método com o nome calcularInss. Este método deverá retornar um double sobre 11% do salário.

Criar um método com o nome calcularValeTransporte. Este método deverá retornar um double sobre 6% do salário.

Criar uma classe com o main e instanciar um funcionário.

Exibir o salário líquido do funcionário conforme imagem abaixo.
*/

package exercicioFixacao_Aula_03;

public class Funcionario {
	private String nome;
	private double salario;
	
	public Funcionario(String nome, double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public double calcularINSS() {
		return salario * 0.11;
	}
	
	public double calcularVT() {
		return salario * 0.06;
	}
	
	
}
