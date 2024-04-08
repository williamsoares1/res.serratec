package classes;

import connect.DAO;

public class Cliente extends DAO{
	private String idCliente;
	private String nome;
	private String endereco;
	
	public String getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Cliente(String idCliente, String nome, String endereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
	}
}
