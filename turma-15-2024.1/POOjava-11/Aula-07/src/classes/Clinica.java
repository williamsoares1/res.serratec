package classes;

public class Clinica extends Plano{	
	private String nome;
	private String cnpj;
	
	public Clinica(String empresa, String nome, String cnpj) {
		super(empresa);
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	@Override
	public String toString() {
		return "Clinica [nome=" + nome + ", cnpj=" + cnpj + "]" + super.toString();
	}
	
	
}
