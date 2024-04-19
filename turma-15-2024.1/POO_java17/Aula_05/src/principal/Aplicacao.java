package principal;

import exercicios.Atleta;
import exercicios.Endereco;
import exercicios.Imovel;
import exercicios.Pessoa;
import exercicios.Time;

public class Aplicacao {

	public static void main(String[] args) {
		exercicio2();
	}
	
	public static void exercicio1() {
		Endereco e = new Endereco("Rua terra, 123", "Centro", "Teresopolis", "RJ");
		Pessoa p = new Pessoa();
		Imovel im = new Imovel(e, "Residencial", 128.000, p);
		
		p.setCpf("12345678933");
		p.setNome("Juca Billin");
		p.setEndereco(e);
		
		System.out.println(p.toString());
		System.out.println(im.toString());
	}
	
	public static void exercicio2() {
		Atleta atleta1 = new Atleta("Neymar", 32, "Atacante");
		Atleta atleta2 = new Atleta("Taffarel", 30, "Goleiro");
		Atleta atleta3 = new Atleta("Romario", 29, "Banheira");
		
		Time time = new Time("Flamengo", "JJ", new Atleta[3]);
		time.addAtleta(atleta1);
		time.addAtleta(atleta2);
		time.addAtleta(atleta3);
		
		System.out.println("Time: " + time.getNomeTime());
		time.mostrarTime();
	}

}
