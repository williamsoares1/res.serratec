package revisao;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String rg;

	public Pessoa() {
		
	}
	
	public Pessoa(String nome) {
		this.setNome(nome);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + "]";
	}
	
	public abstract void cadastrar();
}
