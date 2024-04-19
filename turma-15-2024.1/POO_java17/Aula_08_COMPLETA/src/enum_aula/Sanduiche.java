package enum_aula;

public enum Sanduiche {
	HOTDOG("Hot dog", 7.0), HAMBURGUER("Hamburguer", 15.0), MISTO("Misto quente", 6.5);
	
	private String tipoSanduiche;
	private double valor;
	
	private Sanduiche(String tipoSanduiche, double valor) {
		this.tipoSanduiche = tipoSanduiche;
		this.valor = valor;
	}
	public String getTipoSanduiche() {
		return tipoSanduiche;
	}
	public double getValor() {
		return valor;
	}
	
	
}
