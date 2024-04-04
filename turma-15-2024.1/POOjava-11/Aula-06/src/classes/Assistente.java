package classes;

public class Assistente extends Funcionario{
	private double adicional;

	public Assistente(String nome, double salario, double adicional) {
		super(salario, nome);
		this.adicional = adicional;
	}

	@Override
	public String toString() {
		return super.toString() + "\nAdicional: " + adicional + "\n";
	}
	
	public double getSalario() {
		return this.salario;
	}

	@Override
	public void aumentaSalario() {
		this.salario *= 1.1;
	}
	
}
