package listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Principal {
	public static void main(String[] args) {
		//pessoas();
		//hashSet();
		//treeSet();
		//time();
		comparacao();
	}
	
	public static void pessoas() {
		Pessoa pessoa = new Pessoa("Nome", "123456", 25);
		
		ArrayList<Pessoa> p = new ArrayList<Pessoa>();
		
		p.add(pessoa);
		p.add(new Pessoa("joão", "78784454", 30));
	}
	
	public static void hashSet() {
		Set<String> s = new HashSet<String>();
		
		s.add("Flamengo");
		s.add("Serrano");
		s.add("Goias");
		s.add("Vasco");
		s.add("Flamengo");
		s.add("Botafogo");
		s.add("Botafogo");
		
		System.out.println("hashset: " + s);
	}
	
	public static void treeSet() {
		Set<String> s = new TreeSet<String>();
		
		s.add("Flamengo");
		s.add("Serrano");
		s.add("Goias");
		s.add("Vasco");
		s.add("Flamengo");
		s.add("Botafogo");
		s.add("Botafogo");
		
		System.out.println("treeset: " + s);
	}
	
	public static void time() {
		Time time = new Time("Flamengo", "Tite", "Rodolfo");
		
		Atleta a1 = new Atleta("Zico", 30, "Atacante");
		Atleta a2 = new Atleta("Romário", 29, "Atacante");
		Atleta a3 = new Atleta("Ricardo Rocha", 30, "Zagueiro");
		Atleta a4 = new Atleta("Tafarel", 30, "Goleiro");
		
		ArrayList<Atleta> lista = new ArrayList<Atleta>();
		
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		time.adicionarAtleta(a4);
		time.adicionarAtletas(lista);
		
		time.imprimirDados();
	}

	public static void comparacao() {
		Pessoa p1 = new Pessoa("Zezinho", "1", 5);
		Pessoa p2 = new Pessoa("Alazão", "1", 10);
		Pessoa p3 = new Pessoa("AA", "1", 11);
		Pessoa p4 = new Pessoa("Bolinha", "1", 4);
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		
		System.out.println(lista);
		
		Collections.sort(lista);
		
		System.out.println(lista);
	}
}
