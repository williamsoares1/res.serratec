package com.serratec.model.entity;

public class Cliente extends Pessoa{
	private String cpf;

	public Cliente() {
		super();
	}

	public Cliente(int codigo, String nome, String endereco, String cpf) {
		super(codigo, nome, endereco);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
