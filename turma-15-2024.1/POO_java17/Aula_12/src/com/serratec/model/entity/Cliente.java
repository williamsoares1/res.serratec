package com.serratec.model.entity;

import java.time.LocalDate;

public class Cliente extends Pessoa {
	private String cpf;
	private char sexo;
	private LocalDate dtNasc;

	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String endereco, String cpf, char sexo, LocalDate dtnasc) {
		super(nome, endereco);
		this.cpf = cpf;
		this.sexo = sexo;
		this.dtNasc = dtnasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public char getSexo() {
		return sexo;
	}

	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
	public LocalDate getDtNasc() {
		return dtNasc;
	}

	
	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	
}
