package classes;

public class Diretor extends Funcionario{
	private String categoria;

	public Diretor(String nome, double salario, String categoria) {
		super(salario, nome);
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCategoria: " + categoria + "\n";
	}

	public String getCategoria() {
		return categoria;
	}

	@Override
	public void aumentaSalario() {
		this.salario = (salario * 1.1) + 1000;
	}

}
