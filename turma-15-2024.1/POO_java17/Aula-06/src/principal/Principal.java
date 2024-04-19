package principal;

import classes.Assistente;
import classes.Diretor;
import classes.Gerente;

public class Principal {

	public static void main(String[] args) {
		//Funcionario func = new Funcionario();
		
		Assistente a = new Assistente("Jubileu", 1000, 100);
		Gerente g = new Gerente("Billie Jean", 2500);
		Diretor d = new Diretor("Fred", 9000, "Desenvolvimento");
		
		a.aumentaSalario();
		g.aumentaSalario();
		d.aumentaSalario();
		
		System.out.println(a.toString());
		System.out.println(g.toString());
		System.out.println(d.toString());
		}

}
