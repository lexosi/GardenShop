package gardenshop;

public class Tree extends Product {

private double height;
	
	public Tree(ProdType prodType, String name, double price, double height) {
		super(ProdType.TREE, name, price);
		this.height = height;
	}

	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Product [prodId=" + super.getProdId() + ", prodType=" + super.getProdType() + ", name=" + super.getName() + ", price=" + super.getPrice() + "height=" + height + "]";
	}

}
