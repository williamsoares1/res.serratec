package atividade2;

import java.util.Arrays;

public class Contato {
	private String nome;
	private Telefone[] telefones;
	private Endereco endereco;

	@Override
	public String toString() {
		return "Contato \n ---------------- \n Nome: " + nome + "\n Endereco: " + endereco.toString();
	}

	public Contato(String nome, Endereco endereco, Telefone[] telefones) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void getTelefones(){
		for(int i = 0; i < telefones.length; i++) {
			System.out.println("Telefone: " + telefones[i].getNumero());
		}
	}

	public void setTelefones(Telefone telefone) {
		boolean adicionou = false;
		for(int i = 0; i < telefones.length; i++) {
			if(telefones[i] == null) {
				telefones[i] = telefone;
				adicionou = true;
				System.out.println("Numero adicionado!");
				return;
			}
		}
		
		if(!adicionou)System.out.println("Não é possivel informar mais numeros.");
	}
	
	public void mostrarTelefones() {
		for(int i = 0; i < telefones.length; i++) {
			System.out.println(telefones[i]);
		}
	}
}
