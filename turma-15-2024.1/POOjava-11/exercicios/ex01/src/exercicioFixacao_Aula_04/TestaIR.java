package exercicioFixacao_Aula_04;

public class TestaIR {

	public static void main(String[] args) {
		PessoaJuridica pj = new PessoaJuridica("Bllie Jean", 50.00, "12345678/0001-12", "1234");
		PessoaFisica pf = new PessoaFisica("Xororó LTDA", 30.50, "87654321/0002-15", "4321121-21");
		
		System.out.println(pj.toString());
		System.out.println(pf.toString());
	}

}
