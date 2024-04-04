package exercicio;

public class Usuarios {
	
	private String nome;
	private String login;
	private String senha;
	private String cargo;
	private double salario;
	
	public Usuarios(String nome, String login, String senha, String cargo, double salario) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public void getInfo() {
		System.out.print("\n\nNome: " + this.nome + ". \nCargo: " + this.cargo + ". \nLogin: " + this.login + ", \nSalario: " + this.salario);
	}
}
