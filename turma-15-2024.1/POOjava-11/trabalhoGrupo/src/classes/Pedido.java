package classes;

import java.util.Date;

import util.Util;

/*idpedido SERIAL PRIMARY KEY,
dtemissao DATE,
dtentrega DATE,
valortotal NUMERIC(10, 2),
observacao TEXT*/

public class Pedido {

	protected int idPedido;
	private Date dtEmissao;
	private Date dtEntrega;
	private double valorTotal;
	private String observacaoPed;
	
	final static Date dt = new Date();
	
	@Override
	public String toString() {
		return "Pedido: " + idPedido + "\nData de Emissao: " + Util.novaDT(dtEmissao) + "\nData entrega: " + Util.novaDT(dtEntrega)
				+ "\nObservacaoPed:" + observacaoPed + "\n";
	}

	public Pedido(int idPedido, Date dtEmissao, Date dtEntrega, double valorTotal, String observacaoPed) {
		super();
		this.idPedido = idPedido;
		this.dtEmissao = dtEmissao;
		this.dtEntrega = dtEntrega;
		this.valorTotal = valorTotal;
		this.observacaoPed = observacaoPed;
	}
	
}
