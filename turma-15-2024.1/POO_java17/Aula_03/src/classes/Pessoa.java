package classes;

public class Pessoa {
	String nome;
	private String endereco;
	private String cpf;
	private char sexo;
	private boolean habilitado;
	private double limiteCredito;
	private float peso;
	private float altura;
	private String observacao = "Isto é uma pessoa";
	private double imc;
	
	public Pessoa() {
		System.out.println("Criando o objeto Pessoa");
		System.out.println(Pessoa.super.toString());
	}
	
	private double calculaIMC() {
		if ((getPeso() != 0) && (getAltura() != 0)) {
			this.imc = getPeso() / (getAltura() * getAltura()); 
			return this.imc;
		} else
			return 0;
	}
	
	public String resultado() {
		double imc = calculaIMC();
		
		System.out.println(imc);
		
		if (imc > 0) {
			if (imc <= 18.4) {
				return "Abaixo do peso";
			} else {
				if (imc <= 24.9) {
					return "Peso normal";
				} else
					return "Acima do peso";
			}
		} else
			return "IMC igual a zero. Impossível calcular.";
	}
	
	public double getImc() {
		if (imc == 0) {
			System.out.println("IMC ainda não calculado.");
		}
		return imc;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	
	public float getPeso() {
		return peso;
	}

	
	public void setPeso(float peso) {
		if(peso <= 0)
			System.out.println("Informe um peso maior que zero");
		else
			this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		if(altura <= 0)
			System.out.println("Informe uma altura maior que zero");
		else
			this.altura = altura;
	}

	
	public String getObservacao() {
		return observacao;
	}
}
