package classes;

public abstract class Plano {
	protected String empresa;
	protected double valorPago = 80;	
	protected double valorIss = 5;
	
	public Plano(String empresa) {
		super();
		this.empresa = empresa;
	}

	public double getValorPago() {
		return valorPago;
	}
	
	public double calcularPagamento() {
		double imposto = this.valorIss / 100;
		double vlDesconto = this.valorPago * imposto;
		
		return this.valorPago = this.valorPago - vlDesconto;
	}

	@Override
	public String toString() {
		return "Plano [empresa=" + empresa + ", valorPago=" + String.format("%.2f", valorPago) 
				+ ", valorIss=" + String.format("%.2f%%", valorIss) + "]";
	}
	
	
}
