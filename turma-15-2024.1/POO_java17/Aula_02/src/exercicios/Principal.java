package exercicios;

public class Principal {

	public static void main(String[] args) {
		ExerciciosVariaveis.variaveis();
		CalculadoraMedia.calcular();
		CalculadoraMedia.calcularNaImpressao();
		CalculadoraMedia.calcularSalario();
		ExerciciosVariaveis.testeSwitch();
		ExerciciosVariaveis.testeSwitch2();		
		Lacos.vericarParImpar();
	}
	
	public static void operadorTernario() {
		int a = 10, b = 11;
		
		//operador ternário
		String c = (a == b)?"Igual":"diferente";
		
		//crio uma variável
		
		int d = (a==b)?0:1;
		
		if (a==b) {
			d = 0;
		} else {
			d = 1;
		}
			
		
		System.out.println(c);
		System.out.println(d);
	}
	

}
