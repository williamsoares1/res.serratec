import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Vetores {
	public static void main(String[] args) {
		//exemplo1();
		//exemplo2();
		//exemplo3();
		//exemplo4();
		//exemplo5();
		//exemplo6();
		//exemplo7();
		//exemplo8();
		//exemplo9();
		//exemplo10();
		//exemplo11();
		exemplo12();
	}
	
	public static void exemplo1() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String[] varVetor = new String[5];
		
		varVetor[0] = "Laranja";
		varVetor[1] = "Maça";
		varVetor[2] = "Morango";
		
		System.out.println("Posição 0: " + varVetor[0]);
		System.out.println("Posição 1: " + varVetor[1]);
		System.out.println("Posição 2: " + varVetor[2]);
		/*
		for (int i = 0; i < 5; i++) {
			System.out.println("Informe a " + i+1 + "ª fruta: ");
			varVetor[i] = input.nextLine();
		}
		*/
		for (int i = 0; i < varVetor.length; i++) {
			System.out.println("Informe a " + (i+1) + "ª fruta: ");
			varVetor[i] = input.nextLine();
		}
		
		int j = 1;
		
		for (String s: varVetor) {
			System.out.println("Fruta " + j + ": " + s);
			j++;
		}
		
		String nomes[] = new String[] {"nome 1", "nome 2", "nome 3", "nome 4", "nome 5"};
		
		for (String s: nomes) {
			System.out.println(s);
		}
		
		nomes[2] = "outro nome";
		
		String sobrenomes[] = {"Oliveira", "Ferreira", "Marques", "Reis"};
		
		for (String s : sobrenomes) {
			System.out.println(s);
		}			
	}
	
	public static void exemplo2() {
		String funcionario [][] = new String[][] 	
				{
					{"Marcos", "1343-4352"},
					{"Pedro", "9084-5909"},
					{"Beatriz", "7344-9456"},
					{"Jorge", "3456-1245"}
				};
				
		for (int i=0; i< funcionario.length; i++) {
			System.out.println("---------------------");
			
			for (int j=0; j < funcionario[i].length; j++) {
				System.out.println(funcionario[i][j] + " posição: " + i + j);
			}
		}
	}
	
	public static void exemplo3() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String funcionario [][] = new String[4][2];
		
		for (int i=0; i<funcionario.length; i++) {
			for (int j=0; j<funcionario[i].length; j++) {
				
				if (j==0) 
					System.out.println("Informe o nome " + (i+1) + ":");
				else
					System.out.println("Informe o telefone: ");
				
				funcionario[i][j] = input.nextLine();
			}
		}
	}
	
	public static void exemplo4() {
		Funcionario func[] = new Funcionario[2];
		
		func[0] = new Funcionario();
		func[0].setNome("Luiz");
		func[0].setCargo("Diretor");
		func[0].setSalario(25000);
		
		func[1] = new Funcionario();
		func[1].setNome("Manoel");
		func[1].setCargo("Vigia");
		func[1].setSalario(3000);
		
		for (int i=0; i<func.length; i++) {
			System.out.println("Nome: " + func[i].getNome() + " - Salário: " + func[i].getSalario());
			System.out.println("Abono salarial: " + func[i].abonoSalario(500));			
		}
	}
	
	public static void exemplo5() {
		List lista = new ArrayList();
		
		lista.add("pato");
		lista.add("urso");
		lista.add("cachorro");
		lista.add("galo");
		lista.add(45445);
		
		System.out.println("Tamanho: " + lista.size());
		System.out.println("Índice 2: " + lista.get(2));
		System.out.println(lista);
		
		lista.remove(0);
		//lista.sort(null);
		System.out.println("Tamanho: " + lista.size());
		System.out.println("Índice 2: " + lista.get(2));
		System.out.println(lista);			
	}
	
	public static void exemplo6() {
		List<String> listaDeAnimais = Arrays.asList("Cachorro", "Papagaio", "Tigre", "Gato", "Coelho");
		
		if (!listaDeAnimais.isEmpty()) {
			//listaDeAnimais.sort(null);
			Collections.sort(listaDeAnimais);
			System.out.println("Os animais são: " + listaDeAnimais);
		}
		
		String animal = "Coelho";
		
		boolean pesquisa = listaDeAnimais.contains(animal);
		System.out.println("A lista contém "+ animal + ": " + (pesquisa?"Contém":"Não contém"));
	}
	
	public static void exemplo7() {
		Funcionario f1 = new Funcionario("Manoel", "Vendedor", 1500);
		Funcionario f2 = new Funcionario("Josefina", "Administração", 2000);
		Funcionario f3 = new Funcionario("Leandro", "Técnico", 2500);
		Funcionario f4 = new Funcionario("Antonio", "Desenvolvedor", 3000);
		
		Cliente c1 = new Cliente();
		c1.setNome("Zezinho");
		
		List lista = new ArrayList();
		lista.add(f1);
		lista.add(f2);
		lista.add(f3);
		lista.add(f4);
		lista.add(c1);
		//lista.add("sfsfsfsaf");
		
		/*
		List<Funcionario> lista2 = new ArrayList<Funcionario>(); //-> com generics a lista toda é de um mesmo tipo
		lista2.add(f1);
		lista2.add(f2);
		lista2.add(f3);
		lista2.add(f4);
		lista2.add(c1); //--> Com generics não é permitido incluir um objeto de outro tipo
		*/
		lista.remove(1);
		
		System.out.println("Tamanho: " + lista.size());
		
		for (int i=0; i<lista.size(); i++) {
			
			if (lista.get(i) instanceof Funcionario) {
				Funcionario f = (Funcionario) lista.get(i);
				System.out.println(f.getNome() + " - " + f.getCargo());
			} else {
				Cliente c = (Cliente) lista.get(i);
				System.out.println(c.getNome());
			}
				
		}
		
		double d = 10;
		float f = (float) d;
				
		
		/*
		for (int i=200; i<=500; i++) {
			lista.remove(i);
		}
		*/
		
	}
	
	public static void exemplo8() {
		Pessoa p1 = new Pessoa("Manoel", "123.899.879-09", 76);
		Pessoa p2 = new Pessoa("Josefina", "423.899.879-09", 50);
		Pessoa p3 = new Pessoa("Antonio", "523.899.879-09", 35);
		Pessoa p4 = new Pessoa("Solimar", "823.899.879-09", 73);
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		
		Collections.sort(lista);
		
		for (int i=0; i<lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
	
	public static void exemplo9() {
		Set<String> times = new HashSet<String>();
		
		times.add("Flamengo");
		times.add("Serrano");
		times.add("Fluminense");
		times.add("Botafogo");
		times.add("Vasco");
		times.add("Flamengo");
		times.add("América");
		
		for (String valor : times) {
			System.out.println(valor);
		}
				
		System.out.println("Total de times da coleção: " + times.size() + "\n");
		
		Iterator<String> valores = times.iterator();
		
		while (valores.hasNext()) {
			String time = valores.next();
			System.out.println(time);
		}
	}
	
	public static void exemplo10() {
		Set<String> times = new TreeSet<String>();
		
		times.add("Flamengo");
		times.add("Serrano");
		times.add("Fluminense");
		times.add("Botafogo");
		times.add("Vasco");
		times.add("Flamengo");
		times.add("América");
		
		System.out.println(times);
		
		for (String valor : times) {
			System.out.println(valor);
		}
				
		System.out.println("Total de times da coleção: " + times.size() + "\n");
		
		Iterator<String> valores = times.iterator();
		
		while (valores.hasNext()) {
			String time = valores.next();
			System.out.println(time);
		}
	}
	
	public static void exemplo11() {
		HashMap<String, String> mapaEstados = new HashMap<>(); 
		
		mapaEstados.put("AC", "Acre");
		mapaEstados.put("AL", "Alagoas");
		mapaEstados.put("AP", "Amapá");
		mapaEstados.put("AM", "Amazonas");
		mapaEstados.put("BA", "Bahia");
		mapaEstados.put("CE", "Ceará");
		mapaEstados.put("DF", "Distrito Federal");
		mapaEstados.put("ES", "Espírito Santo");
		mapaEstados.put("GO", "Goiás");
		
		for (String sigla : mapaEstados.keySet()) {
			System.out.println(sigla + " ");
		}
		
		System.out.println("1-"+mapaEstados);
		System.out.println("2-"+mapaEstados.get("AM"));
		System.out.println("3-"+mapaEstados.values());
		System.out.println("4-"+mapaEstados.entrySet());
		
		for (int i=1; i<mapaEstados.size(); i++) {
			System.out.println("5-"+mapaEstados.get(i));
		}
	}
	
	public static void exemplo12() {
		Map<String, String> carros = new HashMap<String, String>();
		carros.put("VW", "Gol");
		carros.put("Fiat", "Siena");
		carros.put("Ford", "Fiesta");
		carros.put("Renault", "Sandero");
		
		for (String s : carros.keySet()) {
			System.out.println(s);
		}
		
		for (Map.Entry<String, String> entrada : carros.entrySet()) {
			System.out.println(entrada);
		}
	}
	
	public static void limparTela(int tam) {
		for (int i = 0; i < tam; i++) {
			System.out.println("\n");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
