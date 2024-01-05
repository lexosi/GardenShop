package gardenshop.enums;

public enum Colour {

	RED("Red"), 
	BLUE("Blue"),
	WHITE("White"),
	PINK("Pink"),
	YELLOW("Yellow"),
	ORANGE("Orange"), 
	VIOLET("Violet");
	
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
