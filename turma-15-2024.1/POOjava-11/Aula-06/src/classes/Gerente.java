package classes;

public class Gerente extends Funcionario{
	private String nivel;
	
	public Gerente(String nome, double salario) {
		super(salario, nome);
	}

	@Override
	public String toString() {
		return super.toString() + "\nNivel: " + nivel + "\n";
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public void aumentaSalario() {
		this.salario = (salario * 1.15) + 500;
	}

}
