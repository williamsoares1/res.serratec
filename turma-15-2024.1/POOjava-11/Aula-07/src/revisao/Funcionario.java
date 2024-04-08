package revisao;

public abstract class Funcionario extends Pessoa{
	private double salario = 1412;

	@Override
	public String toString() {
		return super.toString() +" Funcionario [salario=" + salario + " ]";
	}
	
	
	
}
