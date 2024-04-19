package classes;

public class Poupanca implements Conta{
	private double saldo;

	@Override
	public void sacarConta(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositarConta(double valor) {
		this.saldo += valor;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
