package exercicios;

public class ExerciciosVariaveis {
	
	public static void variaveis() {
		int idade = 20;
		float altura = 1.75f;
		float peso = 52.5f;
		
		System.out.println("O funcion�rio Jo�o tem: ");
		System.out.println("idade: " + idade);
		System.out.println("altura: " + altura);
		System.out.println("peso: " + peso);
	}
	
	public static void testeSwitch() {
		String day = "Ter�a";		
		
		String result = switch(day) {
		case "Segunda" -> "Dia da semana";
		case "Ter�a" -> "Dia da semana";
		case "Quarta" -> "Dia da semana";
		case "Quinta" -> "Dia da semana";
		case "Sexta" -> "Dia da semana";
		case "S�bado" -> "Fim de semana";
		case "Domingo" -> "Fim de semana";
		default -> "Dia inv�lido";
		};
		
		System.out.println(result);
	}
	
	public static void testeSwitch2() {
		String day = "S�bado";		
		String result;
		
		switch(day) {
			case "Segunda":
			case "Ter�a": 
			case "Quarta": 
			case "Quinta": 
			case "Sexta": result = "Dia da semana"; break;
			case "S�bado": 
			case "Domingo": result = "Fim de semana"; break;
			default: result = "Dia inv�lido";
		}
		
		System.out.println(result);
	}
	
	public static void testeSwitch3() {
		String day = "S�bado";		
		String result;
		
		switch(day) {
			case "Segunda",
				 "Ter�a", 
				 "Quarta", 
				 "Quinta", 
				 "Sexta": result = "Dia da semana"; break;
			case "S�bado", 
				 "Domingo": result = "Fim de semana"; break;
			default: result = "Dia inv�lido";
		}
		
		System.out.println(result);
	}
	
}
