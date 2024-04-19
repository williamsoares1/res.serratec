package classes.imutaveis;

public class Policial {
	protected String cpf;
	protected String nome;
	protected final String lotacao = "Brasilia";
	
	public String mostrarDados() {
		return "Nome: " + this.nome + ", Cpf: " + this.cpf + ", Lotacão: " + this.lotacao + ".";
	}

	public String getLotacao() {
		return lotacao;
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

}
