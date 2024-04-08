package aplicacao;

import java.text.NumberFormat;
import java.util.Locale;

import classes.Livro;
import classes.Operacao;

public class Principal {
	final static NumberFormat NF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	public static void main(String[] args) {
		Livro livro = new Livro("Maurice Leblanc", "Arsene Lupin - Ladrão de Casaca", 24.90);
		Livro livro2 = new Livro("Kathy Sierra", "Use a Cabeça Java", 98.00);
		
		Operacao operacao = new Operacao("Venda", livro);
		Operacao operacao2 = new Operacao("Emprestimo", livro2);
		
		livro.reajuste(livro.getValor() + (livro.getValor() * 0.06));
		
		operacao.venderLivro();
		System.out.println(operacao.getTipo() + " do livro '" + livro.getTitulo() + "' do autor '" + livro.getAutor() + "' no valor de " + NF.format(operacao.getValorOperacao()));
	
		operacao2.emprestarLivro();		
		System.out.println(operacao2.getTipo() + " do livro '" + livro2.getTitulo() + "' do autor '" + livro2.getAutor() + "' no valor de " + NF.format(operacao2.getValorOperacao()));
	}

}
