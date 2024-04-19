package classes;

public class Cdb implements Conta{
	private double saldo;
	private double iof;
	
	@Override
	public void sacarConta(double valor) {
		this.saldo -= valor + this.iof;
	}

	@Override
	public void depositarConta(double saldo) {
		this.saldo = saldo;
	}

	public void setIof(double iof) {
		this.iof = iof;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
