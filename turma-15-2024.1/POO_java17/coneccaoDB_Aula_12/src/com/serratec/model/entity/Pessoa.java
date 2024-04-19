package com.serratec.model.entity;

public abstract class Pessoa {
	private int codigo;
	private String nome;
	private String endereco;
	
	public Pessoa() {
		//nothing
	};
	
	public Pessoa(int codigo, String nome, String endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
}
