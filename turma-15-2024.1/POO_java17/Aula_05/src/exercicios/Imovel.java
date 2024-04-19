package exercicios;

public class Imovel {
	private Endereco endereco;
	private String tipo;
	private double valor;
	private Pessoa proprietario;
	
	public Imovel(Endereco endereco, String tipo, double valor, Pessoa proprietario) {
		super();
		this.endereco = endereco;
		this.tipo = tipo;
		this.valor =valor;
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Imovel [=" + endereco + ", tipo=" + tipo + ", valor=" + valor + ", proprietario=" + proprietario
				+ "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	
	
}
