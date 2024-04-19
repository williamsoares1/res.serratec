package classes;

public class Operacao implements Livraria{
	private String tipo;
	private double valorOperacao;
	private Livro livro;
	
	public Operacao(String tipo, Livro livro) {
		super();
		this.tipo = tipo;
		this.livro = livro;
	}
	
	@Override
	public String toString() {
		return "Operacao [tipo=" + tipo + ", valorOperacao=" + valorOperacao + ", livro=" + livro + "]";
	}

	@Override
	public void emprestarLivro() {
		this.valorOperacao = (livro.getValor() * 0.02) + taxaEmprestimo;
	}

	@Override
	public void venderLivro() {
		this.valorOperacao = livro.getValor() + (livro.getValor() * 0.09);
	}

	public String getTipo() {
		return tipo;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
