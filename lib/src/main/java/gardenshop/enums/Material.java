package gardenshop.enums;

public enum Material {
	
	WOOD("Wood"),
	PLASTIC("Plastic");
	
	private final String material;
	
	Material(String material) {
		this.material = material;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String toString() {
		return this.material.toLowerCase();
	}
	
	public static Material getMaterial(String string) {
		return null;
	}
}
