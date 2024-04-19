package enum_aula;

import java.time.LocalDate;
import java.util.Scanner;

import enum_aula.Pessoa.EstadoCivil;

public class Principal {
	public static void main(String[] args) {
		//televisao();
		//turma();
		//pessoa();
		lanche();
	}
	
	public static void televisao() {
		TV tv1 = new TV(43, "TU7000", MarcaTV.SAMSUNG);
		TV tv2 = new TV(32, "SN3200", MarcaTV.PANASONIC);
		
		System.out.println(tv1);
		System.out.println(tv2);
		
		System.out.println("------------------");
		
		for (MarcaTV tv: MarcaTV.values()) {
			System.out.println(tv);
		}
	}
	
	public static void turma() {
		Turma turma = new Turma("Java", PeriodoCurso.INTEGRAL);
		
		System.out.println("Curso: " + turma.getCurso());
		System.out.println("Dias da semana: " + turma.getPeriodoCurso().getDiaSemana());
		System.out.println("Carga horária: " + turma.getPeriodoCurso().getCargaHoraria());
		System.out.println("Valor do curso: " + turma.getPeriodoCurso().getValor());
	}
	
	public static void pessoa() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		EstadoCivil ec = EstadoCivil.CASADO;
		
		System.out.println("Informe o nome: ");
		String nome = input.nextLine();
		
		System.out.println("Informe o estado civil: ");
		System.out.println("""
				C - Casado
				D - Divorciado
				V - Viúvo
				S - Solteiro
				""");
		char estado = input.next().charAt(0);
				
		switch(estado) {
		case 'C': ec = EstadoCivil.CASADO; break;
		case 'D': ec = EstadoCivil.DIVORCIADO; break;
		case 'V': ec = EstadoCivil.VIUVO; break;
		case 'S': ec = EstadoCivil.SOLTEIRO;
		default: System.out.println("Opção inválida"); 
		}	
		
		Pessoa pessoa = new Pessoa(nome, "email@email.com.br", Setor.COMPRAS, 
				ec);
		
		System.out.println(pessoa);
		
		Setor[] setores = Setor.values();
		
		for (int i=0; i<setores.length; i++) {
			System.out.println(setores[i]);
		}
		
		for (Setor setor: Setor.values()) {
			System.out.println(setor);
		}
	}

	public static void lanche() {
		Pedido pedido = new Pedido(LocalDate.now(), Bebida.REFRIGERANTE, Sanduiche.HAMBURGUER);
		
		pedido.imprimirCardapio();
		
		System.out.println("-------------------------");
		System.out.println(pedido);
		System.out.println("-------------------------");
		System.out.println("Total do Pedido: " + pedido.calcularPedido());
		System.out.println("-------------------------");
	}
}
