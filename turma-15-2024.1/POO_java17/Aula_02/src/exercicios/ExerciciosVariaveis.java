package exercicios;

public class ExerciciosVariaveis {
	
	public static void variaveis() {
		int idade = 20;
		float altura = 1.75f;
		float peso = 52.5f;
		
		System.out.println("O funcionário João tem: ");
		System.out.println("idade: " + idade);
		System.out.println("altura: " + altura);
		System.out.println("peso: " + peso);
	}
	
	public static void testeSwitch() {
		String day = "Terça";		
		
		String result = switch(day) {
		case "Segunda" -> "Dia da semana";
		case "Terça" -> "Dia da semana";
		case "Quarta" -> "Dia da semana";
		case "Quinta" -> "Dia da semana";
		case "Sexta" -> "Dia da semana";
		case "Sábado" -> "Fim de semana";
		case "Domingo" -> "Fim de semana";
		default -> "Dia inválido";
		};
		
		System.out.println(result);
	}
	
	public static void testeSwitch2() {
		String day = "Sábado";		
		String result;
		
		switch(day) {
			case "Segunda":
			case "Terça": 
			case "Quarta": 
			case "Quinta": 
			case "Sexta": result = "Dia da semana"; break;
			case "Sábado": 
			case "Domingo": result = "Fim de semana"; break;
			default: result = "Dia inválido";
		}
		
		System.out.println(result);
	}
	
	public static void testeSwitch3() {
		String day = "Sábado";		
		String result;
		
		switch(day) {
			case "Segunda",
				 "Terça", 
				 "Quarta", 
				 "Quinta", 
				 "Sexta": result = "Dia da semana"; break;
			case "Sábado", 
				 "Domingo": result = "Fim de semana"; break;
			default: result = "Dia inválido";
		}
		
		System.out.println(result);
	}
	
}
