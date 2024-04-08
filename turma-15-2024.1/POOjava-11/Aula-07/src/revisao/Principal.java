package revisao;

public class Principal {

	public static void main(String[] args) {		
		Fornecedor p1 = new Fornecedor();
		System.out.println(p1.getNome());
		
		p1.setNome("Ricardo");
		
		Assistente p2 = new Assistente();
		
		System.out.println(p1.getNome());
		System.out.println(p2.getNome());
		
		Cliente f = new Cliente();
		
		f.setNome("Emanoel");
		f.setCpf("123456");
		f.setRg("852339");
		
		System.out.println(f.toString());
		
		/*
		classes estáticas
		classes concretas
		classes abstratas
		
		* p1 - Fornecedor
		* p2 - Assistente
		* f - Cliente
		*/
		
		
		
		imprimirP(p1);
		imprimirP(p2);
		imprimirP(f);
		
		imprimirF(p1);
		//imprimirF(p2);
		//imprimirF(f);
		
		//imprimirC(p1);
		//imprimirC(p2);
		imprimirC(f);
		
		//imprimirE(p1);
		imprimirE(p2);
		//imprimirE(f);
		
		//imprimirA(p1);
		imprimirA(p2);
		//imprimirA(f);
		
	}

	public static void imprimirP(Pessoa p) {
		System.out.println(p.toString());
	}
	
	public static void imprimirF(Fornecedor p) {
		System.out.println(p.toString());
	}
	
	public static void imprimirC(Cliente p) {
		System.out.println(p.toString());
	}
	
	public static void imprimirE(Funcionario p) {
		System.out.println(p.toString());
	}
	
	public static void imprimirA(Assistente p) {
		System.out.println(p.toString());
	}
}
