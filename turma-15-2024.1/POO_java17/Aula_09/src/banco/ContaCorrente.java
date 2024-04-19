package banco;

public class ContaCorrente implements Conta {
	private String numero;
	private double saldo;
	public ContaCorrente(String numero, double saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	public void depositaConta(double valor) {
		this.saldo += valor;
	}
	
	public boolean saqueConta0(double valor) {
		if (this.saldo <= valor) {
			return false;
		} else {
			this.saldo -= valor;
			return true;
		}
	}
	
	public boolean saqueConta(double valor) {
		if (valor <= 0) {
			//throw new RunTimeException(); => Essa classe não pode ser utilizada pois é a classe mãe de todas
			//throw new IllegalArgumentException("O valor não pode ser negativo ou igual a zero.");
			throw new ValorInvalido("O valor não pode ser negativo ou igual a zero.");			
		} else {
			if (this.saldo >= valor) {
					this.saldo -= valor;
					return true;
			} else {
				//throw new IllegalArgumentException("Saldo insuficiente.");
				throw new SaldoNegativo("Saldo insuficiente.");
			}
		}
	}
}
