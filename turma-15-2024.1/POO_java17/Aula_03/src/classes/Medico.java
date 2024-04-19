package classes;

public class Medico {
	private String crm;
	private String nome;
	private double salario;
	private double valorConsulta;
	private int totalConsultas;
	private double totalDinheiro;
	private double totalPlano;
	private static int totalMedicos = 0;
	
	private Medico() {
		Medico.totalMedicos++;
	}

	public Medico(String crm, String nome, double salario, double valorConsulta) {
		this();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
		this.valorConsulta = valorConsulta;
	}
	
	public void pagamentoDinheiro() {
		this.salario += getValorConsulta();
		this.totalDinheiro += getValorConsulta();
		this.totalConsultas++;
	}
	
	public double pagamentoDinheiro(double desconto) {
		double total = getValorConsulta()- desconto;
		
		this.totalDinheiro += total; 
		this.salario += total;		
		this.totalConsultas++;	
		
		return total;
	}
	
	public void pagamentoPlano() {
		this.salario += getValorConsulta() * 0.7;
		this.totalPlano += getValorConsulta() * 0.7;
		this.totalConsultas++;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public static int getTotalMedicos() {
		return totalMedicos;
	}

	public int getTotalConsultas() {
		return totalConsultas;
	}

	public double getTotalDinheiro() {
		return totalDinheiro;
	}
	
	public double getTotalPlano() {
		return totalPlano;
	}
}
