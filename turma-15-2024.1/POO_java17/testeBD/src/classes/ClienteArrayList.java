package classes;

public class ClienteArrayList {
	private String nome;
	private String observacao;
	private int idade;
	
	public ClienteArrayList(String nome, String observacao, int idade) {
		super();
		this.nome = nome;
		this.observacao = observacao;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "ClienteArrayList [nome=" + nome + ", observacao=" + observacao + ", idade=" + idade + "]";
	}
	
	
}
