package classes;

public class Atleta implements Olimpiadas{
	private String nome;
	private String modalidade;
	private double peso;
	private static int totalParticipantes;
	private Pais pais;

	public Atleta(String nome, double peso, Pais pais) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.pais = pais;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public static int getTotalParticipantes() {
		return totalParticipantes;
	}

	@Override
	public String verificaSituacao() {
		if(this.peso > 90) {
			this.modalidade = "peso pesado";
		}else if(this.peso >= 60) {
			this.modalidade = "peso médio";
		}else {
			this.modalidade = "Não aprovado";
			return "Não participará";
		}
		
		this.totalParticipantes++;
		return "participará na modalidade " + this.modalidade;
	}

}
