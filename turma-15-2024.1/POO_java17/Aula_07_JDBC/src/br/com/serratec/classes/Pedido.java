package br.com.serratec.classes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Pedido {
	private int idpedido;
	private String numero;
	private double valorPedido;
	private Date dataPedido;
	private Cliente cliente = new Cliente();
	private ArrayList<PedItem> produto = new ArrayList<>();	
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<PedItem> getPedItem() {
		return this.produto;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void imprimirItensPedido() {
		System.out.println("Produtos do pedido: " + getNumero());
		System.out.println("-----------------------------------");
		for (PedItem pi:produto) {
			System.out.println("Código: "+ pi.getIdProduto());
			System.out.println("Descrição: "+ pi.getDescricao());
			System.out.printf("Quantidade: %,2.3f", pi.getQuantidade());
			System.out.printf("%nPreço: R$ %,2.2f", pi.getVlPreco());
			System.out.printf("%nTotal: R$ %,2.2f", pi.getQuantidade() * pi.getVlPreco());	
			System.out.println("\n-----------------------------------");
		}
	}
	
	
	public void adicionarProduto(PedItem itens) {
		PedItem peditem = new PedItem();
		
		peditem.setDescricao(itens.getDescricao());
		peditem.setIdProduto(itens.getIdProduto());
		peditem.setVlCusto(itens.getVlCusto());
		peditem.setVlPreco(itens.getVlPreco());
		peditem.setQuantidade(itens.getQuantidade());
		
		produto.add(peditem);
	}
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(java.util.Date dataPedido) {
		long timeInMiliSegundos = dataPedido.getTime();
		
		this.dataPedido = new java.sql.Date(timeInMiliSegundos);
	}
	public String getStringDataPedido() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(this.dataPedido);
		
		return data;		
	}
	
}
