package gardenshop.enums;

public enum ProdType {
	
	TREE("Tree"),
	FLOWER("Flower"),
	DECORATION("Decoration");

	private final String prodType;
	
	ProdType(String prodType) {
		this.prodType = prodType;
	}
	
	public String getProdType() {
		return prodType;
	}
	
	public String toString() {
		return this.prodType.toLowerCase();
	}
	
	public static ProdType getProdType(String string) {
		return null;
	}
}