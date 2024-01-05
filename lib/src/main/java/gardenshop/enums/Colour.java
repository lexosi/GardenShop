package gardenshop.enums;

public enum Colour {

	RED("R"), 
	BLUE("B"),
	WHITE("W"),
	PINK("P"),
	YELLOW("Y"),
	ORANGE("O"), 
	VIOLET("V");
	
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
