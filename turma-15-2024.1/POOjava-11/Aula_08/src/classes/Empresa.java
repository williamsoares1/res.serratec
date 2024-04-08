package classes;

public class Empresa implements Tributos{
	private String razaoSocial;
	private double rendimentos;

	@Override
	public String toString() {
		return "Razão Social: " + razaoSocial + ", Rendimento: " + rendimentos + "\n";
	}

	public Empresa(String razaoSocial, double rendimentos) {
		super();
		this.razaoSocial = razaoSocial;
		this.rendimentos = rendimentos;
	}

	@Override
	public double calculaIR() {
		// TODO Auto-generated method stub
		return this.rendimentos * irEmpresa;
	}

	@Override
	public double calculaICMS() {
		// TODO Auto-generated method stub
		return this.rendimentos * icms;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public double getRendimentos() {
		return rendimentos;
	}

}
