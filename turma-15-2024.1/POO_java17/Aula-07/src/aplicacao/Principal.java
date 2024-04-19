package aplicacao;

import classes.Anestesista;
import classes.Clinica;
import classes.Medico;

public class Principal {
	public static void main(String[] args) {
		Clinica clinica = new Clinica("Amil", "Checkup", "123.456.789/0001-98");
		Medico medico = new Medico("Golden Cross", "Carlos da Silva", "1345445");
		Anestesista anestesista = new Anestesista("Amil", "Mariana", "123456", "Peridural");
		
		clinica.calcularPagamento();
		medico.calcularPagamento();
		anestesista.calcularPagamento();
		
		System.out.println(clinica.toString());
		System.out.println(medico.toString());
		System.out.println(anestesista.toString());
	}
}
