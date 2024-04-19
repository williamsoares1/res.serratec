package classes;

public class Anestesista extends Medico{
	private String tipoAnestesia;
	
	public Anestesista(String empresa, String nome, String crm,
		String tipoAnestesia) {
		
		super(empresa, nome, crm);
		this.tipoAnestesia = tipoAnestesia;
	}

	public String getTipoAnestesia() {
		return tipoAnestesia;
	}

	@Override
	public String toString() {
		return "Anestesista [tipoAnestesia=" + tipoAnestesia + String.format("%.2f", getValorPago())  + "]";
	}

	public double calcularPagamento() {
		double imposto = this.valorIss / 100;
		//System.out.println("imposto: " + imposto);
		double vlCorrigido = (this.valorPago * 1.1) + 1000;
		//System.out.println("valor pago: " + vlCorrigido);
		double vlDesconto = vlCorrigido * imposto;
		//System.out.println("vldesconto: " + vlDesconto);
		//System.out.println("valorPago: " + (vlCorrigido - vlDesconto));
		return this.valorPago = vlCorrigido - vlDesconto; 
	}
}
