package gardenshop;

import gardenshop.enums.ProdType;

public abstract class Product {
	
	private int prodId;
	private static int prodIdNext;
	private ProdType prodType;
	private String name;
	private double price;
	
	public Product(ProdType prodType, String name, double price) {
		this.prodId = Product.prodIdNext;
		Product.prodIdNext++;
		this.prodType = prodType;
		this.name = name;
		this.price = price;
	}

	public int getProdId() {
		return prodId;
	}
	public ProdType getProdType() {
		return prodType;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	public void setProdType(ProdType prodType) {
		this.prodType = prodType;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + this.prodId + ", prodType=" + this.prodType + ", name=" + this.name + ", price=" + this.price + "]";
	}
	
}
