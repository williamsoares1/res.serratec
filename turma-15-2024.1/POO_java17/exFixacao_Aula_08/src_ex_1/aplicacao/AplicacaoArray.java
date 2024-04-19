package aplicacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Atleta;
import classes.Pais;

public class AplicacaoArray {

	public static void main(String[] args) {
		boolean continuar = true;
		
		
		List<String> nomes = Arrays.asList("Anderson Silva", "Jon Jones", "Vitor Belfort");
		List<Double> pesos = Arrays.asList(98d, 59d, 110d);
		List<Pais> paises = Arrays.asList(new Pais("Brasil"), new Pais("EUA") , new Pais("Brasil"));
		
		ArrayList<Atleta> listaAtletas = new ArrayList<Atleta>(); 
		
		int i = 0;
		
		do {
			listaAtletas.add(cadastrarAtleta(nomes.get(i), pesos.get(i), paises.get(i)));
			i++;
			if(i > nomes.size() - 1) {
				break;
			}
		}while(continuar);
		System.out.println("Total de Participantes: " + Atleta.getTotalParticipantes());
	}
	
	public static Atleta cadastrarAtleta(String nome, double peso, Pais pais){
		Atleta a = new Atleta(nome, peso, pais);
		System.out.println("O atleta " + a.getNome() + " " + a.verificaSituacao());
		return a;
	}
}
