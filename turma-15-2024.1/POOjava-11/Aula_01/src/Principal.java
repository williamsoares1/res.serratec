import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Olá, mundo");
		Date minhadata = new Date();
		
		
		/*
		String s = """				
				
				1- Cadastrar
				2- Alterar
				3- Excluir
				4- Sair
				
				"""; 
		
		System.out.println(s);
		
		String variavel = "lkjf lfjsdaçljf lsçjfçlsajf çsajfçl" +
				" sajçfjsaçfsçaf jksaç"
				+ " sf jmsaflçjsaçlfj saçlfjçlsajf çljsaflç js";
		
		System.out.println(variavel);
		
		System.out.println(s + " - alguma coisa qualquer");
		*/
		//estudo();
		//comparaNumeros(100, 50);
		//fJonathan(50, 100);
		//divizaoPorZero();
		//casting();
		
		testes();
	}
	
	public static void testes() {
		System.out.print("Wi\"ll\"iam\"");
		System.out.print("Soares\"");
	}
	
	public static void estudo() {
		final String CABECALHO = "Dados"; // declaração de constante
		final String LINHA = "-----------------------------------------";
		
		int anoNasc;		   // inteiro
		double peso;           // real
		char sexo;             // caracter
		boolean canhoto;       // logico
		String nome, resposta; // cadeia
		
		anoNasc = 2005;
		peso = 69.90;
		sexo = 'M';
		canhoto = true;
		nome = "Wilha";
		
		if (canhoto){
			resposta = "Sim";
		}else resposta = "Não";
		
		System.out.println(CABECALHO+"\n"+LINHA+ "\nNome: "+nome+ "\nPeso: "+peso+ "\nSexo: "+sexo+ "\nCanhoto: "+resposta+ "\nAno Nascimento: "+anoNasc);
	
		var x = 2;      // Assume o tipo int
		var y = 10.3;	// Assume o tipo double
		var z = true;	// Assume o tipo boolean
		
		// var será melhor utilizado quando trabalhar com generics
		// var pode causar confusão se muito utilizado
		
		double numeroDouble = 100.0;	// 8 bytes
		float numeroFloat;				// 4 bytes
		
		long numeroLong;				// 8 bytes 01010111 01011101 01010111 01011101 01010111 01011101 01010111 01011101 
		int numeroInt;					// 4 bytes 01010111 01011101 01010111 01011101
		short numeroShort;				// 2 bytes 01010111 01011101
		byte numeroByte;				// 1 byte  01011101
		
		numeroLong = 10;		// inteiro para long
		numeroFloat = 5L;		// long para float
		numeroDouble = 2.3f;	// float para double 
		//numeroInt = 3.5;		// double para int (não é possível dessa forma)
		numeroByte = 127;
		
		numeroInt = (int) numeroDouble;
		
		int i = (int) 3.6;  //casting
		
		System.out.println("número truncado = " + i);
	}
	
	public static void comparaNumeros(double num1, double num2) {
		double maior, menor;
		
		if (num1 > num2 ) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;
		}
		
		System.out.println(maior + " é maior que " +menor +".");
	}
	
	public static void fJonathan(double num1, double num2)  {
		if (num1 > num2) {
			System.out.println("Numero 1 é maior que numero 2");
		}else {
			System.out.println("Numero 2 é maior que numero 1");
		}
	}
	
	public static void divizaoPorZero() {
		System.out.println("\nDivisões por zero:\n");
		System.out.println(0.0/0);
		System.out.println(10.0/0);
		System.out.println(0/0);
	}
	
	public static void casting() {
		
		//conversões implícitas
		long x = 10; 	// int para long  (cabe, porque int é menor que long
		double x1 = 35;	// int para double (converte para 35.0)	
		float x2 = 40;   // int para float também é normal
		//float x3 = 40.0; // double para float não pode, pois float é menor que double
		float x4 = 40.0f; // float em float		
		float x5 = (float) 40.0; // assim também pode, pois explicitou o casting		
		//short x6 = 100000;  //número muito grande para short
		short x7 = (short) 100000; // vai converter, mas vai desconfigurar o número, pois esse int é maior que short		
		byte x8 = (byte) 130; // vai converter, mas vai desconfigurar o número, pois esse int é maior que byte
		
		//-127 a 127
		System.out.println("short = " + x7);
		System.out.println("byte = " + x8);
	}
	
	public static void estruturaCondicional() {
		
		int num = 10;
		  
		if (num > 10) {  
			System.out.println("O número é maior que 10");
			System.out.println(" oie ");
		} else if (num < 10) {  	
			System.out.println("O número é menor que 10"); 
		} else { 
			System.out.println("O número é 10"); 
		}
		
		 
		int num2 = 2;
		double num3 = 2.0;
		byte num4 = 2;
		long num5 = 2;
		float num6 = 2.0f;
		char num7 = '2';
		
		switch (num7) {
		case '1':
			System.out.println("O número é 1");
			break;
		case '2':
			System.out.println("O número é 2");
			break;
		case '3':
			System.out.println("O número é 3");
			break;
		default:
			System.out.println("O número é outro");
			break;
		}		
	}

	public static void estruturaRepeticao() {
	
		int x = 0;
		
		while (x <= 10) {
			System.out.println(x);
			x++;
		}
		
		x = 0;
		
		while (true) {
			System.out.println(x);
			
			if (x == 10) {
				break;
			}
			x++;
		}
		
		x = 0;
		
		while (x <= 10) {			
			x++;
			
			if (x == 5) {
				continue;
			}
			
			System.out.println(x);			
		}
		
		x = 1;
		
		do {
			System.out.println(x);
			x++;
		
		} while (x <= 10);
		
		
		for (int i = 0; i < 10; i++ ) {
			System.out.println(i);
		}
		
		//i = 2;
		
		int i, j;
		
		for (i = 0, j = 10; i < 10; i++, j--) {
			System.out.println(i + " - " + j);
		}
		
		i = j +100;
		
		for (;i < 10;) {
			System.out.println(i);
			i++;
		}
		
		i = 0;
		
		for (;;) {
			System.out.println(i);
			i++;
			if (i == 10) {
				break;
			}
	}
}
}
