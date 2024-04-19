package listas;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private String cpf;
	private int idade;
	
	public Pessoa(String nome, String cpf, int idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}
	/*
	@Override
	public int compareTo(Pessoa o) {
		return nome.compareTo(o.getNome());
	}
	*/
	
	@Override
	public int compareTo(Pessoa o) {
		if(idade < o.getIdade()) {
			return -1;
		} else if (idade > o.getIdade()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	
	
}
