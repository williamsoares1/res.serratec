package classes;

import util.Util;

public class PedidoItens {
	
	private double valorUnitario;
	private double valorDesconto;
	private Produto produto;
	private Cliente cliente;
	private Pedido pedido;
	protected int idPedidoitem;
    protected int quantidade_produto;
    
    
   
//    @Override
//	public String toString() {
//		return "ValorUnitario: " + Util.converterMonetario(produto.getValorVenda()) + "\nValorDesconto: " 
//				+ Util.converterMonetario(valorDesconto)
//				+ produto + "\nIdPedidoitem: " + idPedidoitem + "\nQuantidade pedido: " + quantidade_produto
//				+ "\nTotal pedido: " + Util.converterMonetario(produto.getValorVenda() * quantidade_produto)
//				+ "\n";
//    }

	@Override
	public String toString() {
		return  Util.linhaSimples(20) + produto + "\nQuantidade: " + quantidade_produto + "\nValor total: " + Util.converterMonetario(valorUnitario)
				+ "\nValor Desconto: " + Util.converterMonetario(valorDesconto) + "\n" + cliente + "\n" + pedido + "idPedidoitem: " 
				+ idPedidoitem + "\n" + Util.linhaSimples(20)
				+ "\n\n";
	}

	public PedidoItens(double valorUnitario, double valorDesconto, Produto produto, Cliente cliente, Pedido pedido,int idPedidoitem,
		int quantidade_produto) {
		super();
		this.valorUnitario = valorUnitario;
		this.valorDesconto = valorDesconto;
		this.produto = produto;
		this.pedido = pedido;
		this.cliente = cliente;
		this.idPedidoitem = idPedidoitem;
		this.quantidade_produto = quantidade_produto;
	}
	
	public PedidoItens(double valorUnitario, double valorDesconto, int idPedidoitem,
			int quantidade_produto) {
			super();
			this.valorUnitario = valorUnitario;
			this.valorDesconto = valorDesconto;
			this.idPedidoitem = idPedidoitem;
			this.quantidade_produto = quantidade_produto;
		}
	
	public double getValorUnitario() {
		return valorUnitario;
		
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
		
	}
	public double getValorDesconto() {
		return valorDesconto;
		
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
		
	}
	public Produto getProduto() {
		return produto;
		
	}
	public int getQuantidade_produto() {
		return quantidade_produto;
		
	}
    
    
}
