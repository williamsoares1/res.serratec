package exercicioFixacao_Aula_04;

public class PessoaJuridica extends ImpostoDeRenda{
	private String cnpj;
	private String inscEstatual;
	
	public PessoaJuridica(String nome, double rendimentos, String cnpj, String inscEstatual) {
		super(nome, rendimentos);
		this.cnpj = cnpj;
		this.inscEstatual = inscEstatual;
	}
	
	@Override
	public String calculoIR() {
		return String.format("%.2f", rendimentos * 0.15);
	}

	@Override
	public String toString() {
		return super.toString() + "PessoaJuridica \nCnpj: " + cnpj + "\nInscEstatual: " + inscEstatual + "\nValor a pagar: " + calculoIR() + "\n";
	}
}
