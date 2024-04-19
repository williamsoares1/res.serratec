package enum_aula;

public enum Bebida {
	REFRIGERANTE("refrigerante", 3.0), SUCO("Suco", 6.5), AGUA("Água mineral", 3.0);
	
	private final String tipoBebida;
	private final double valor;
	
	private Bebida(String tipoBebida, double valor) {
		this.tipoBebida = tipoBebida;
		this.valor = valor;
	}

	public String getTipoBebida() {
		return tipoBebida;
	}

	public double getValor() {
		return valor;
	}	
}
