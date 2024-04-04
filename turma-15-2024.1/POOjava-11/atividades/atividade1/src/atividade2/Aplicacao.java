package atividade2;

public class Aplicacao {

	public static void main(String[] args) {
		Telefone t1 = new Telefone("21 97676-7676");
		Telefone t2 = new Telefone("21 97878-7878");
		Telefone t3 = new Telefone("22 94656-4656");
		Telefone t4 = new Telefone("21 93938-3735");
		Telefone t5 = new Telefone("21 99121-2123");
		Telefone t6 = new Telefone("21 97753-1212");
		Telefone t7 = new Telefone("21 96231-1291");
		
		Estado e1 = new Estado("Rio de Janeiro", "RJ");
		Estado e2 = new Estado("São Paulo", "SP");
		Estado e3 = new Estado("Santa Catarina", "SC");
		Estado e4 = new Estado("Bahia", "BA");
		
		Cidade c1 = new Cidade("Teresopolis", e1);
		Cidade c2 = new Cidade("Londrina", e2);
		Cidade c3 = new Cidade("Joinville", e3);
		Cidade c4 = new Cidade("Salvador", e4);
		
		Endereco en1 = new Endereco("Rua Branca", "Brind", "23333", c1);
		Endereco en2 = new Endereco("Rua Nod", "Reta", "55221", c2);
		Endereco en3 = new Endereco("Rua Ruca", "Polo", "55231", c3);
		Endereco en4 = new Endereco("Rua Oak", "Kind", "61543", c4);
		
		Contato co1 = new Contato("Jubileu", en1, new Telefone[2]);
		co1.setTelefones(t1);
		co1.setTelefones(t2);
		Contato co2 = new Contato("Billie Jean", en2, new Telefone[3]);
		co2.setTelefones(t3);
		co2.setTelefones(t4);
		co2.setTelefones(t5);
		Contato co3 = new Contato("Jubileu", en3, new Telefone[1]);
		co3.setTelefones(t6);
		Contato co4 = new Contato("Jubileu", en4, new Telefone[1]);
		co4.setTelefones(t7);
		
		System.out.println(co1.toString());
		co1.getTelefones();
	}

}
