package com.serratec.model.entity;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<LivrosEstoque> livrosBiblioteca;
	private ArrayList<ClientesBiblioteca> clientes;
	private ArrayList<LivrosEmprestados> livrosEmprestados;
	
	private class LivrosEstoque extends Livro{
		private int quantEstoque;

		public int getQuantEstoque() {
			return quantEstoque;
		}

		public void setQuantEstoque(int quantEstoque) {
			this.quantEstoque = quantEstoque;
		}
	}
	
	private class LivrosEmprestados extends Livro{
		private int quantEmprestimo;
		private int quantDevolvida;

		public int getQuantDevolvida() {
			return quantDevolvida;
		}

		public void setQuantDevolvida(int quantDevolvida) {
			this.quantDevolvida = quantDevolvida;
		}

		public int getQuantEmprestimo() {
			return quantEmprestimo;
		}

		public void setQuantEmprestimo(int quantEmprestimo) {
			this.quantEmprestimo = quantEmprestimo;
		}
	}
	
	private class ClientesBiblioteca extends com.serratec.model.entity.Cliente{
		ArrayList<LivrosEmprestados> livrosEmprestados;
	}
	
	//------------------------------------------------
	
	public void cadastrarLivro(Livro livro, int qtEstoque) {
		if(!this.livrosBiblioteca.contains(livro)){
		LivrosEstoque lv = new LivrosEstoque();
		
		lv.setAutor(livro.getAutor());
		lv.setCodigo(livro.getCodigo());
		lv.setEditora(livro.getEditora());
		lv.setIsbn(livro.getIsbn());
		lv.setTitulo(livro.getTitulo());
		lv.setValor(livro.getValor());
		lv.setQuantEstoque(qtEstoque);
		
		this.livrosBiblioteca.add(lv);
		}else
			System.out.println("Livro já cadastrado.");
	}

	public void excluirLivro(Livro livro) {
		if(this.livrosBiblioteca.contains(livro)) {
			this.livrosBiblioteca.remove(livro);
		};
	}

	public void alterarQuantidadeEstoque(Livro livro, int quantidade) {
		if(this.livrosBiblioteca.contains(livro)) {
			
			int index = this.livrosBiblioteca.indexOf(livro);
			
			this.livrosBiblioteca.get(index).setQuantEstoque(quantidade);
		}
	}
	
	public void cadastrarCliente(Cliente cliente) {
		if(this.clientes.contains(cliente)) {
		ClientesBiblioteca cl = new ClientesBiblioteca();
		
		cl.setCodigo(cliente.getCodigo());
		cl.setCpf(cliente.getCpf());
		cl.setEndereco(cliente.getEndereco());
		cl.setNome(cliente.getNome());
		
		this.clientes.add(cl);
		}else
			System.out.println("Cliente já cadastrado");
	}

	public void excluirCliente(Cliente cliente) {
		if(this.clientes.contains(cliente)) {
			this.clientes.remove(cliente);
		};
	}
	
	public void selecionarLivro(Cliente cliente, String titulo, int quantidade) {
		Livro lv = new Livro();
		boolean livroEncontrado = false;
		
		for(LivrosEstoque le: this.livrosBiblioteca) {
			
			if(le.getTitulo().equals(titulo)) {
				
				if((le.quantEstoque > 0) && (le.quantEstoque >= quantidade)) {
				lv.setAutor(le.getAutor());
				lv.setCodigo(le.getCodigo());
				lv.setEditora(le.getEditora());
				lv.setIsbn(le.getIsbn());
				lv.setTitulo(le.getTitulo());
				lv.setValor(le.getValor());
				le.setQuantEstoque(le.getQuantEstoque() - quantidade);
				
				this.livrosEmprestados.add((LivrosEmprestados) lv);
				int index = this.livrosEmprestados.indexOf(lv);
				this.livrosEmprestados.get(index).setQuantEmprestimo(quantidade);
				
				livroEncontrado = true;
				}
				else {
					System.out.println("Não há livros disponiveis.");
					break;
				}
			}
		}
		
		if(!livroEncontrado) {
			System.out.println("Livro não encontrado.");
		}
	}
	
	public void concluirEmprestimo(Cliente cliente) {
		emprestarLivro(cliente, this.livrosEmprestados);
	}
	
	private void emprestarLivro(Cliente cliente, ArrayList<LivrosEmprestados> livros) {
		
		if(!this.clientes.contains(cliente)) {
			cadastrarCliente(cliente);			
		}
		
		int index = this.clientes.indexOf(cliente);
		
		for(LivrosEmprestados le: livros) {
			this.clientes.get(index).livrosEmprestados.add(le);
		};
				
		livros.clear();
	}
	
	private void devolverLivro(Cliente cliente, Livro livro, int quantidade) {
		if(this.clientes.contains(cliente)){
			int index = this.clientes.indexOf(cliente);
			if(this.clientes.get(index).livrosEmprestados.contains(livro)) {
				int i = this.clientes.get(index).livrosEmprestados.indexOf(livro);
				
				LivrosEmprestados le = this.clientes.get(index).livrosEmprestados.get(index);
				
				if((le.quantEmprestimo - le.quantDevolvida >= quantidade)) {
					le.setQuantDevolvida(le.quantDevolvida + quantidade);
					
					if(this.livrosBiblioteca.contains(livro)) {
						int j = this.livrosBiblioteca.indexOf(livro);
						this.livrosBiblioteca.get(j).quantEstoque += quantidade;
					}
				} else {
					System.out.println("Quantidade maior que a esperada.");
				}
			}
		}else {
			System.out.println("Cliente não encontrado.");
		}
	}
	
	public void listarLivrosBiblioteca() {
		System.out.printf("%s\t%-20s\t%-15s\t%-15s\t%-6s\t%5s\t%9s\\n", "Codigo", "Autor", "Editora", "Titulo", "isbn", "Quant estoque", "Valor");
			for(LivrosEstoque le: this.livrosBiblioteca) {
			System.out.printf("%d\t%-20s\t%-15s\t%-15s\t%-6s\t%5d\t%9.2f\n", le.getCodigo(), le.getAutor(), le.getEditora(), le.getTitulo(), le.getIsbn(), le.getQuantEstoque(), le.getValor());
		}
	}
}
