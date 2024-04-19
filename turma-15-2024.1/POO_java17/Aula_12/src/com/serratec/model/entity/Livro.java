package com.serratec.model.entity;

public class Livro {
	private int codigo;
	private String titulo;
	private String isbn;
	private String autor;
	private String editora;
	private double valor;
	
	public Livro() {
		
	}
	
	public Livro(int codigo, String titulo, String isbn, String autor, String editora, double valor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
