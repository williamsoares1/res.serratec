package br.com.serratec.classes;

public class Produto {
	private int idProduto;
	private String descricao;
	private double vlCusto;
	private double vlPreco;
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getVlCusto() {
		return vlCusto;
	}
	public void setVlCusto(double vlCusto) {
		this.vlCusto = vlCusto;
	}
	public double getVlPreco() {
		return vlPreco;
	}
	public void setVlPreco(double vlPreco) {
		this.vlPreco = vlPreco;
	}
}
