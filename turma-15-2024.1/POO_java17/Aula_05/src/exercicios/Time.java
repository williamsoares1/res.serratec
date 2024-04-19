package exercicios;

public class Time {
	private String nomeTime;
	private String tecnico;
	private Atleta[] atletas;
	
	public Time(String nomeTime, String tecnico, Atleta[] atleta) {
		super();
		this.nomeTime = nomeTime;
		this.tecnico = tecnico;
		this.atletas = atleta;
	}
	
	public String getNomeTime() {
		return nomeTime;
	}

	public String getTecnico() {
		return tecnico;
	}

	public Atleta[] getAtleta() {
		return atletas;
	}
	
	public void addAtleta(Atleta atleta) {
		boolean adicionou = false;
		for(int i = 0; i < atletas.length; i++) {
			if(atletas[i] == null) {
				atletas[i] = atleta;
				adicionou = true;
				System.out.println("Atleta aceito!");
				return;
			}
		}
		
		if(!adicionou)System.out.println("Time já está completo!");
	}
	
	public void mostrarTime() {
		for(int i = 0; i < atletas.length; i++) {
			System.out.println(atletas[i].getNome());
		}
	}
}
