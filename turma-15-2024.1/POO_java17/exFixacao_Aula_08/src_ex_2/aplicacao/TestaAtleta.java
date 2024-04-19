package aplicacao;

import classes.Atleta;
import classes.Pais;

public class TestaAtleta {

	public static void main(String[] args) {
		Pais pais1 = new Pais("Brazil");
		Pais pais2 = new Pais("EUA");
		
		Atleta a1 = new Atleta("Anderson Silva", 98, pais1);
		Atleta a2 = new Atleta("Jon Jones", 59, pais2);
		Atleta a3 = new Atleta("Vitor Belfort", 110, pais1);
		
		participacao(a1);
		participacao(a2);
		participacao(a3);
		
		System.out.println("Total de Participantes: " + Atleta.getTotalParticipantes());
	}
	
	public static void participacao(Atleta a) {
		System.out.println("O atleta " + a.getNome() + " " + a.verificaSituacao());
	}

}
