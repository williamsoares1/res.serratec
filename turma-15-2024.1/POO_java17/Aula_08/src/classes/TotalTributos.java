package classes;

public class TotalTributos {
	private double total;
	
	public void totalizaTributos(Tributos t) {
		this.total += t.calculaICMS();
		this.total += t.calculaIR();
		
		System.out.println(t.toString() + "ICMS: " + t.calculaICMS());
		System.out.println("IR: " + t.calculaIR() + "\n");
	}
	
	public double getTotal() {
		return total;
	}
}
