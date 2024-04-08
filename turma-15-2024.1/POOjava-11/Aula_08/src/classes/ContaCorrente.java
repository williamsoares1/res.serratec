package classes;

public class ContaCorrente implements Conta{
	private double saldo;
	private double taxa = 1.3;

	@Override
	public void sacarConta(double valor) {
		this.saldo -= valor + taxa;
	}

	@Override
	public void depositarConta(double valor) {
		this.saldo += valor;	
	}
	
	public double getSaldo() {
		return saldo;
	}

}
