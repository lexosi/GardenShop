package gardenshop;

import gardenshop.enums.Material;
import gardenshop.enums.ProdType;

public class Decoration extends Product {

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
		return "(" + super.toString() + ", Material: " + this.material + ")";
	}
}
