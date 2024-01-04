package gardenshop;

public class TcktProdLine {

	private int numLine;
	private static int numLineNext;
	private int prodQtyTicket;
	private Product prodTicket;
	private double priceXunit;
	
	public TcktProdLine(int prodQtyTicket, Product prodTicket) {
		this.numLine = TcktProdLine.numLineNext;
		TcktProdLine.numLineNext++;
		this.prodQtyTicket = prodQtyTicket;
		this.prodTicket = prodTicket;
		this.priceXunit = prodTicket.getPrice();
	}
	
	
	public int getNumLine() {
		return numLine;
	}
	public int getProdQtyTicket() {
		return prodQtyTicket;
	}
	public Product getProdTicket() {
		return prodTicket;
	}
	public double getPriceXunit() {
		return priceXunit;
	}
	
	
	public void setProdQtyTicket(int prodQtyTicket) {
		this.prodQtyTicket = prodQtyTicket;
	}
	public void setProdTicket(Product prodTicket) {
		this.prodTicket = prodTicket;
	}
	
	
	@Override
	public String toString() {
		return String.format("Quantity %d Product %s Price/unit %.2f Total %.2f %n", this.prodQtyTicket, this.prodTicket.getName(), this.prodTicket.getPrice(), (this.priceXunit * this.prodQtyTicket));
	}
	
}