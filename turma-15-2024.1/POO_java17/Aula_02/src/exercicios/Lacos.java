package exercicios;

public class Lacos {
	public static void vericarParImpar() {
		for (int i=0; i<=30; i++) {
			if(i % 2 == 0) {
				System.out.println(i + " é par.");
			} else {
				System.out.println(i + " é ímpar.");
			}
		}
	}
}
