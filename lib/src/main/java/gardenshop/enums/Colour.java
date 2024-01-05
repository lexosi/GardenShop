package gardenshop.enums;

public enum Colour {

	WHITE("W"), 
	YELLOW("Y"), 
	RED("R"), 
	ORANGE("O"), 
	VIOLET("V"), 
	BLUE("B"), 
	PINK("P");
	
	private final String colour;
	
	Colour(String colour) {
		this.colour = colour;
	}
	
	public String getColour() {
		return colour;
	}
	
	public String toString() {
		return this.colour.toLowerCase();
	}
	
	public static Colour getColour(String string) {
		return null;
	}
}
