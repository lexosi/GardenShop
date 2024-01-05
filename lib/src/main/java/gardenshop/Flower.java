package gardenshop;

import gardenshop.enums.Colour;
import gardenshop.enums.ProdType;

public class Flower extends Product {

	private Colour colour;
	
	
	public Flower(ProdType prodType, String name, double price, Colour colour) {
		super(ProdType.FLOWER, name, price);
		this.colour = colour;
	}
	
	
	public Colour getColour() {
		return colour;
	}
	
	public void setColour(Colour colour) {
		this.colour = colour;
	}



	@Override
	public String toString() {
		return "Product [prodId=" + super.getProdId() + ", prodType=" + super.getProdType() + ", name=" + super.getName() + ", price=" + super.getPrice() + "colour=" + this.colour + "]";
	}
}
