package exercicios;

public class Pessoa {
	private String cpf;
	private String nome;
	private Endereco endereco;
	
	public String toString() {
		return "Cpf: " + cpf + "\nNome: " + nome + "\nEndereco: " + endereco.toString();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
