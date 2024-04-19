package enum_aula;

public class TV {
	private int tamanho;
	private String modelo;
	private MarcaTV marca;
	
	public TV(int tamanho, String modelo, MarcaTV marca) {
		super();
		this.tamanho = tamanho;
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getTamanho() {
		return tamanho;
	}

	public String getModelo() {
		return modelo;
	}

	public MarcaTV getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return "TV [tamanho=" + tamanho + ", modelo=" + modelo + ", marca=" + marca + "]";
	}
	
	
}
