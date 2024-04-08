package exercicioFixacao_Aula_04;

public class PessoaFisica extends ImpostoDeRenda{
	private String cpf;
	private String rg;
	
	public PessoaFisica(String nome, double rendimentos, String cpf, String rg) {
		super(nome, rendimentos);
		this.cpf = cpf;
		this.rg = rg;
	}
	
	@Override
	public String toString() {
		return super.toString() + "PessoaFisica \nCpf: " + cpf + "\nRG: " + rg + "\nValor a pagar: " + calculoIR() + "\n";
	}

	@Override
	public String calculoIR() {
		return String.format("%.2f", rendimentos * 0.12);
	}
}
