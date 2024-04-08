package classes;

import util.Util;

public class Produto {
	
	private int idProduto;
	private double valorCusto;
	private double valorVenda;
	private int quantidade;
	private String descricao;
	private String categoria;
		
	// Constructor
	
	public Produto(int idProduto, double valorCusto, double valorVenda, int quantidade, String descricao, String categoria) {
		super();
		this.idProduto = idProduto;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	// toString
	@Override
	public String toString() {
		return 	descricao + "\nidProduto: " + idProduto + "\nvalorCusto = "
				+ Util.converterMonetario(valorCusto) + "\nValor Venda: " + Util.converterMonetario(valorVenda)
				+ "\nQuantidade no estoque:  " + quantidade + "\nCategoria: " + categoria;
	}
	
	
	// Getters and Setters
	public double getValorCusto() {
		return valorCusto;
	}
		

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
