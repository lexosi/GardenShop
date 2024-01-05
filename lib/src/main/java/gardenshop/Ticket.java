package gardenshop;

import java.util.ArrayList;
import java.util.List;


public class Ticket {

	private int ticketId;
	private static int ticketIdNext;
	private List<TcktProdLine> prodLines;
	private double totalAmount; // subtotal (sum of all products)
	private double totalSaleAmount; // total ticket amount(with tax applied)
	
	
	public Ticket() {
		this.ticketId = Ticket.ticketIdNext;
		Ticket.ticketIdNext++;
		this.prodLines = new ArrayList<TcktProdLine>();
		this.totalAmount = 0;
		this.totalSaleAmount = 0;
	}
	
	
	public int getTicketId() {
		return ticketId;
	}
	public List<TcktProdLine> getProdLines() {
		return prodLines;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}
	
	
	public void setProdLines(TcktProdLine tcktProdLine) {
		this.prodLines.add(tcktProdLine);
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	
	
	// Product Methods
	public void addProd(Product product, int quantity) {		
		TcktProdLine tcktProdLine = new TcktProdLine(quantity, product);
		setProdLines(tcktProdLine);
		tcktProdLine.setProdQtyTicket(quantity);
		tcktProdLine.setProdTicket(product);
		tcktProdLine.setTotalPriceProd(product.getPrice() * quantity);
	}
	
	
	public double calculateTotalAmount() {
		double subtotal = 0;
		subtotal = prodLines.stream().mapToDouble(TcktProdLine::getTotalPriceProd).sum();
		setTotalAmount(subtotal);
		
		calculateTotalAmountWTax();
		return subtotal;
	}
	
	public double calculateTotalAmountWTax() {
		double subtotal = getTotalAmount();	
		double tax = 0.21d;
		double totalAmountWTax = 0;
		
		totalAmountWTax = subtotal + (subtotal * tax); 
		setTotalSaleAmount(totalAmountWTax);
		
		return totalAmountWTax;
	}
	
	@Override
	public String toString() {
		return  "\t\tSale num: " + this.ticketId + "\n"
				+ "Quantity\tDescription\tPrice/Unit\tTotal\n"
				+ this.prodLines + "\n"
				+ "Subtotal:\t\t\t\t\t" + this.calculateTotalAmount() + " €\n"
				+ "Total price(with 21% tax)\t\t\t" + this.calculateTotalAmountWTax() + " €";
	}
	
}
