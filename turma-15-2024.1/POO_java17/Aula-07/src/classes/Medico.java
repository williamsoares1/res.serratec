package classes;

public class Medico extends Plano{
	protected String nome;
	protected String crm;
	
	public Medico(String empresa, String nome, String crm) {
		super(empresa);
		this.nome = nome;
		this.crm = crm;
	}
	
	public double calcularPagamento() {
			
		return this.valorPago = super.calcularPagamento() * 1.1; 
	}

	@Override
	public String toString() {
		return "Medico [nome=" + nome + ", crm=" + crm + " Valor pago="+ String.format("%.2f", getValorPago()) + "]";
	}

	public String getNome() {
		return nome;
	}

	public String getCrm() {
		return crm;
	}
	
	
}
