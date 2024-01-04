package gardenshop;

public class Decoration extends Product {

	public enum Material { WOOD, PLASTIC };
	private Material material;
	
	
	public Decoration(ProdType prodType, String name, double price, Material material) {
		super(ProdType.DECORATION, name, price);
		this.material = material;
	}
	
	
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}



	@Override
	public String toString() {
		return "Product [prodId=" + super.getProdId() + ", prodType=" + super.getProdType() + ", name=" + super.getName() + ", price=" + super.getPrice() + "material=" + this.material + "]";
	}
}
