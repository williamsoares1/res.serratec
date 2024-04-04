package principal;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!");
		
		String variavelNome = "William";
		
		System.out.println("Olá " + variavelNome + "!!");
		
		//usuario();
		//comparaNum(132,130);
		//divisaoPorZero();
		//casting();
		//estruturaCondicional();
		estruturasDeRepeticao();
	}
	
	public static void usuario() {
		final String CABECALHO = "Dados";
		final String LINHA = "---------------------------------------------";
		
		int anoNasc;
		double peso;
		char sexo;
		boolean canhoto;
		String nome, resposta;
		
		anoNasc = 2005;
		peso = 63.50;
		sexo = 'M';
		canhoto = true;
		nome = "William Soares da Cunha Silva";
		
		if(canhoto) {
			resposta = "Sim";
		}else {
			resposta = "Não";
		}
		
		System.out.println(
				"\n" + CABECALHO + "\n" + LINHA
				+ "\nNome: " + nome 
				+ "\nPeso: " + peso
				+ "\nSexo: " + sexo
				+ "\nAno de nascimento: " + anoNasc
				+ "\nCanhoto: " + resposta
				+ "\n" + LINHA);
		
		var x = 2; //Assume o tipo int
		var y = 10.6; //Assume o tipo float
		var z = "A"; //Assume o tipo String
		
		double numDouble = 100.00; // 8 bytes
		float numFloat; // 4 bytes
		
		long numLong; // 8 bytes
		int numInt; // 4 bytes
		short numShort; // 2 bytes
		byte numByte; // 1 byte (>= -127 e <=127)
		
		numLong = 10; // inteiro para long
		numFloat = 5L; // long para float
		numDouble = 2.3f; // float para double
		//numInt = 3,5; //double para int (não é possivel dessa forma);
		
		numInt = (int) numDouble;
		
		int i = (int) 3.5; //retorn somente o 3
	}
	
	public static void comparaNum(double num1, double num2) {
		String resposta;
		
		if(num1 < num2) {
			resposta = num1+" é menor que " + num2;
		}else if(num1 > num2) {
			resposta = num1+" é maior que " + num2;
		}else if(num1 == num2) {
			resposta = num1+" é igual a " + num2;
		}else {
			resposta = "Invalido";
		}
		
		System.out.println(resposta);
	}
	
	public static void divisaoPorZero() {
		System.out.println("\nDivisão por zero: ");
		System.out.println(0.0/0);
		System.out.println(10.0/0);
		System.out.println(0/0);
	}
	
	public static void casting() {
		long x = 10;
		double x1 = 35;
		float x2 = 40;
		//float x3 = 40.0;
		float x4 = 40.0f;
		float x5 = (float) 40.0;
		//short x6 = 100000;
		short x7 = (short) 100000;
		byte x8 = (byte) 130; 
		
		System.out.println("Short = " + x7);
		System.out.println("Byte = " + x8);
	}
	
	public static void estruturaCondicional() {
		int num = 9;
		String resposta;
		
		if(num > 10) {
			resposta = "O numero é maior que 10";
		}else
			if(num < 10) {
				resposta = "O numero é menor que 10";
			}
			else {
				resposta = "O número é igual a 10";
			}
		
		System.out.println(resposta);
		
		int num1 = 1;
		char char1 = '3';

		switch(char1) {
		case '1':
			System.out.println("O numero é 1");
			break;
		case '2':
			System.out.println("O numero é 2");
			break;
		case '3':
			System.out.println("O numero é 3");
			break;
		default:
			System.out.println("O numero é invalido");
			break;
		}
		
		/*switch(num1) {
		case 1:
			System.out.println("O numero é 1");
			break;
		case 2:
			System.out.println("O numero é 2");
			break;
		case 3:
			System.out.println("O numero é 3");
			break;
		default:
			System.out.println("O numero é invalido");
			break;
		}*/
		
	}

	public static void estruturasDeRepeticao() {
		int x = 0;
		
		while(x <= 10) {
			System.out.println(x + " a");
			x++;
		}
		
		x = 0;
		
		while(true) {
			System.out.println(x + " b");
			
			if(x==10) {
				break;
			}
			x++;
		}
		
		x = 0;
		
		while (x <= 10) {
			x++;
			
			if(x == 5) {
				continue;
			}
			
			System.out.println(x + " c");
		}
		
		x = 1;
		
		do {
			System.out.println(x + " d");
			x++;
		} while (x <= 10);
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " e");
		}
		
		int i, j;
		
		for(i = 0, j = 10; i < 10; i++, j--) {
			System.out.println(i + " f " + j);
		}
		
		i = j + 100;
		
		for(;i < 10;) {
			System.out.println(i + " g");
			i++;
		}
		
		i = 0;
		
		for(;;) {
			System.out.println(i + " h");
			i++;
			
			if(i == 10) {
				break;
			}
		}
	}
}