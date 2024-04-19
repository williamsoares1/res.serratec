package com.serratec.model.entity;

import java.util.ArrayList;

public class Biblioteca {
	
	private class LivrosEstoque extends Livro{
		private int quantEstoque;
		private int quantEmprestada;

		public int getQuantEstoque() {
			return quantEstoque;
		}		
		public void setQuantEstoque(int quantEstoque) {
			this.quantEstoque = quantEstoque;			
		}

		public int getQuantEmprestada() {
			return quantEmprestada;
		}

		public void setQuantEmprestada(int quantEmprestada) {
			this.quantEmprestada = quantEmprestada;
		}		

	}
	
	public class LivrosEmprestados extends Livro{
		private int idlivroCliente;
		private int quantEmprestimo;
		private int quantDevolvida;
		
		public int getQuantEmprestimo() {
			return quantEmprestimo;
		}
		
		private void setQuantEmprestimo(int quantEmprestimo) {
			this.quantEmprestimo = quantEmprestimo;
		}

		
		public int getQuantDevolvida() {
			return quantDevolvida;
		}

		
		public void setQuantDevolvida(int quantDevolvida) {
			this.quantDevolvida = quantDevolvida;
		}

		public int getIdlivroCliente() {
			return idlivroCliente;
		}

		public void setIdlivroCliente(int idlivroCliente) {
			this.idlivroCliente = idlivroCliente;
		}	
	}
	
	public class ClienteBib extends com.serratec.model.entity.Cliente {
		private int idClientebib;
		private String numero_socio;
		
		public ArrayList<LivrosEmprestados> livrosEmprestados;
		public String getNumero_socio() {
			return numero_socio;
		}
		public void setNumero_socio(String numero_socio) {
			this.numero_socio = numero_socio;
		}
		public int getIdClientebib() {
			return idClientebib;
		}
		public void setIdClientebib(int idClientebib) {
			this.idClientebib = idClientebib;
		}
		public ArrayList<LivrosEmprestados> getLivrosEmprestados() {
			return livrosEmprestados;
		}
	}
	
	private ArrayList<LivrosEstoque> livrosBiblioteca;
	private ArrayList<ClienteBib> clientes;
	private ArrayList<LivrosEmprestados> livrosEmprestados;
	
	//--------------------------------------------------------------	
	
	public void imprimirDadosClientesBib(ArrayList<ClienteBib> clientes) {
		
	}
	
 	public void cadastrarLivro(Livro livro, int qtEstoque) {
		if (!this.livrosBiblioteca.contains(livro)) {
			LivrosEstoque lv = new LivrosEstoque();
			
			lv.setAutor(livro.getAutor());
			lv.setCodigo(livro.getCodigo());
			lv.setEditora(livro.getEditora());
			lv.setIsbn(livro.getIsbn());
			lv.setTitulo(livro.getTitulo());
			lv.setValor(livro.getValor());
			lv.setQuantEstoque(qtEstoque);
			
			this.livrosBiblioteca.add(lv);	
		} else
			System.out.println("Livro já cadastrado.");
	}
	
	public void excluirLivro(Livro livro) {
		if (this.livrosBiblioteca.contains(livro)) {
			this.livrosBiblioteca.remove(livro);
		}
	}
	
	public void atualizarQuantidadeEstoque(Livro livro, int quantidade) {
		
		
		if (this.livrosBiblioteca.contains(livro)) {
			int index = this.livrosBiblioteca.indexOf(livro);
			this.livrosBiblioteca.get(index).setQuantEstoque(quantidade);
			
			/*
			for (LivrosEstoque lv: this.livrosBiblioteca) {
				if (lv.getIsbn().equals(livro.getIsbn())) {
					lv.setQuantEstoque(quantidade);
					break;
				}				
			}
			*/
		}
	}
	
	public void cadastrarCliente(Cliente cliente) {
		
		if (!this.clientes.contains(cliente)) {
			ClienteBib cl = new ClienteBib();
			
			cl.setCodigo(cliente.getCodigo());
			cl.setCpf(cliente.getCpf());
			cl.setEndereco(cliente.getEndereco());
			cl.setNome(cliente.getNome());
			
			this.clientes.add(cl);
		} else
			System.out.println("Cliente já cadastrado.");
	}
	
	public void excluirCliente(Cliente cliente) {
		if (this.clientes.contains(cliente)) {
			this.clientes.remove(cliente);
		}
	}
	
	public void selecionarLivro(String titulo, int quantidade) {	
		Livro lv = new Livro();
		boolean livroEncontrado = false;
		
		for (LivrosEstoque le: this.livrosBiblioteca) {
			
			if (le.getTitulo().equals(titulo)) {
				
				if ((le.quantEstoque > 0) && 
						(le.quantEstoque - le.quantEmprestada >= quantidade)){
					lv.setAutor(le.getAutor());
					lv.setCodigo(le.getCodigo());
					lv.setEditora(le.getEditora());
					lv.setIsbn(le.getIsbn());
					lv.setTitulo(le.getTitulo());
					lv.setValor(le.getValor());
					
					le.setQuantEmprestada(le.getQuantEmprestada() + quantidade);
					
					this.livrosEmprestados.add((LivrosEmprestados) lv);
					int i = this.livrosEmprestados.indexOf(lv);
					this.livrosEmprestados.get(i).setQuantEmprestimo(quantidade);
					
					livroEncontrado = true;
				} else
					System.out.println("Não há quantidade em estoque para emprestar.");
				break;				
			} 			
		}	
		
		if (!livroEncontrado) System.out.println("Livro não encontrado.");
	}
	
	public void concluirEmprestimo(Cliente cliente) {
		emprestarLivro(cliente, this.livrosEmprestados);
	}
		
	private void emprestarLivro(Cliente cliente, ArrayList<LivrosEmprestados> livros) {		
		
		if (!this.clientes.contains(cliente)) {
			cadastrarCliente(cliente);
		}
		
		int index = this.clientes.indexOf(cliente);
		
		for (LivrosEmprestados le: livros) {
			this.clientes.get(index).livrosEmprestados.add(le);		
		}
		
		livros.clear();
	}
	
	public void devolverLivro(Cliente cliente, Livro livro, int quantidade) {
		if (this.clientes.contains(cliente)) {
			int index = this.clientes.indexOf(cliente);
			if (this.clientes.get(index).livrosEmprestados.contains(livro)) {
				int i = this.clientes.get(index).livrosEmprestados.indexOf(livro);
				LivrosEmprestados le = this.clientes.get(index).livrosEmprestados.get(i);
				
				if ((le.quantEmprestimo - le.quantDevolvida >= quantidade)){
					le.setQuantDevolvida(le.quantDevolvida + quantidade);
					
					if (this.livrosBiblioteca.contains(livro)) {
						int j = this.livrosBiblioteca.indexOf(livro);
						this.livrosBiblioteca.get(j).quantEstoque += quantidade;						 
					}
					
				} else {
					System.out.println("Quantidade é maior que a esperada.");
					System.out.println("Quantidade emprestada   = " + le.quantEmprestimo);
					System.out.println("Quantidade já devolvida = " + le.quantDevolvida);
				}
			} else {
				System.out.println("Este livro não foi emprestado para esse cliente.");
			}
		} else {
			System.out.println("Cliente não cadastrado na biblioteca.");
		}
	}

	public void listarLivrosBiblioteca() {
		
		System.out.printf("%s\t%-20s\t%-15s\t%-15s\t%-6s\t%9s\t%5s\n", "Código", "Título", "Autor", "Editora", "ISBN", "Valor", "Estoque");
		
		for (LivrosEstoque le: this.livrosBiblioteca) {
			System.out.printf("%d\t%-20s\t%-15s\t%-15s\t%-6s\t%9.2f\t%5d\n"
					, le.getCodigo()
					, le.getTitulo()
					, le.getAutor()
					, le.getEditora()
					, le.getIsbn()
					, le.getValor()
					, le.getQuantEstoque());
		}
		
	}
}
