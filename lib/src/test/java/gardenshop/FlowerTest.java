package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.Colour;
import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {
    @Test
    void testColour() {
        Flower flower = new Flower(ProdType.FLOWER, "Test Flower", 10.0, Colour.RED);
        assertEquals(Colour.RED, flower.getColour());
    }

    @Test
    void testSetColour() {
        Flower flower = new Flower(ProdType.FLOWER, "Test Flower", 10.0, Colour.RED);
        flower.setColour(Colour.BLUE);
        assertEquals(Colour.BLUE, flower.getColour());
    }

    @Test
    void testToString() {
        Flower flower = new Flower(ProdType.FLOWER, "Rose", 10, Colour.RED);
        String expected = "(" + super.toString() + ", Colour: " + flower.getColour() + ")";

        assertEquals(expected, flower.toString());
    }
}
