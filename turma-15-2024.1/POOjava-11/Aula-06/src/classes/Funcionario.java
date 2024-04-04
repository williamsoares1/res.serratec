package classes;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Funcionario {
	final static NumberFormat NF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	protected double salario;
	protected String cpf;
	protected String nome;
	protected String turno;
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nSalario: " + NF.format(salario) + "\nCpf: " + cpf + "\nTurno: " + turno;
	}

	public Funcionario(double salario, String nome) {
		super();
		this.salario = salario;
		this.nome = nome;
	}

	public double getBonificacao() {
		return this.salario * 0.10;
	}
	
	public abstract void aumentaSalario();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getSalario() {
		return salario;
	}

	public String getNome() {
		return nome;
	}
}
