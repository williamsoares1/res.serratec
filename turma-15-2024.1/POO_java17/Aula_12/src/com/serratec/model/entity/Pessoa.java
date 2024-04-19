package com.serratec.model.entity;

public abstract class Pessoa {
	private int codigo;
	private String nome;
	private String endereco;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCodigo(int codigo) {
		if (this.codigo == 0) {
			this.codigo = codigo;
		}
	}
}
