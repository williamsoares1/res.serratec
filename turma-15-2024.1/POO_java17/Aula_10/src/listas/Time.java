package listas;

import java.util.ArrayList;

public class Time {
	private String nomeTime;
	private String tecnico;
	private String diretor;	
	private ArrayList<Atleta> atletas = new ArrayList<Atleta>();
	
	public Time(String nomeTime, String tecnico, String diretor) {
		super();
		this.nomeTime = nomeTime;
		this.tecnico = tecnico;
		this.diretor = diretor;
	}

	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}
	
	public Atleta buscarAtleta(String nome) {
		Atleta localizado = null;
		
		for (Atleta a: this.atletas) {
			if (a.getNome().equals(nome)) {
				localizado = a;
				break;
			}
		}
		
		if (localizado == null) {
			System.out.println("Atleta não localizado.");
		}
		
		return localizado;
	}

	public void adicionarAtletas(ArrayList<Atleta> atletas) {
		for (Atleta a: atletas) {
			this.atletas.add(a);
		}
	}
	
	public void adicionarAtleta(Atleta atleta) {
		this.atletas.add(atleta);
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public String getTecnico() {
		return tecnico;
	}

	public String getDiretor() {
		return diretor;
	}
	
	public void imprimirDados() {
		final String LINHA = "------------------------------------------";
		
		System.out.println(LINHA);
		System.out.println("Time: " + this.nomeTime);
		System.out.println("Técnico: " + this.tecnico);
		System.out.println("Diretor: " + this.diretor);
		System.out.println(LINHA);
		System.out.println("Atletas");
		System.out.println(LINHA);
		for (Atleta a: this.atletas) {
			System.out.printf("  %-15s \t%s\t%s\n", a.getNome(), a.getIdade(), a.getPosicao());
		}
		System.out.println(LINHA);
	}
}
