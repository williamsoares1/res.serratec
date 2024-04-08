package classes;

public class Pessoa implements Tributos{
	private String nome;
	private double rendimentos;
	
	public Pessoa(String nome, double rendimentos) {
		super();
		this.nome = nome;
		this.rendimentos = rendimentos;
	}
	
	public String getNome() {
		return nome;
	}

	public double getRendimentos() {
		return rendimentos;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Rendimentos: " + rendimentos + "\n";
	}

	@Override
	public double calculaIR() {
		// TODO Auto-generated method stub
		return this.rendimentos * irPessoa;
	}

	@Override
	public double calculaICMS() {
		// TODO Auto-generated method stub
		return 0;
	}
}
