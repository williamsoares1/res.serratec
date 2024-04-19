package aplicacao;

import classes.Cdb;
import classes.ContaCorrente;
import classes.Empresa;
import classes.Pessoa;
import classes.Poupanca;
import classes.TotalTributos;
import classes.imutaveis.Policial;

public class Principal {

	public static void main(String[] args) {
		policial();
	}
	
	public static void banco() {
		Poupanca poupanca = new Poupanca();
		ContaCorrente cc = new ContaCorrente();
		Cdb cdb = new Cdb();
		
		poupanca.depositarConta(1000);
		cc.depositarConta(2000);
		cdb.depositarConta(2500);
		
		poupanca.sacarConta(120);
		cc.sacarConta(200);
		
		cdb.setIof(1.0);
		cdb.sacarConta(400);
		
		
		System.out.println("Poupanca: " + poupanca.getSaldo());
		System.out.println("Poupanca: " + cc.getSaldo());
		System.out.println("Poupanca: " + cdb.getSaldo());
	}
	
	public static void impostos() {
		Pessoa p = new Pessoa("Joaquim", 2000);
		Empresa e = new Empresa("Xororo LTDA", 58000);
		TotalTributos t = new TotalTributos();
		
		t.totalizaTributos(p);
		t.totalizaTributos(e);
		
		System.out.println("Total Geral de Tributos: " + t.getTotal());
	}
	
	public static void policial() {
		Policial policia = new Policial();
		
		policia.setNome("Parrera");
		policia.setCpf("1212");
		
		System.out.println(policia.mostrarDados());
	}

}
