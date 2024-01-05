package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.Material;
import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class DecorationTest {
    @Test
    void testMaterial() {
        Decoration decoration = new Decoration(ProdType.DECORATION, "Test Decoration", 10.0, Material.WOOD);
        assertEquals(Material.WOOD, decoration.getMaterial());
    }

    @Test
    void testSetMaterial() {
        Decoration decoration = new Decoration(ProdType.DECORATION, "Test Decoration", 10.0, Material.WOOD);
        decoration.setMaterial(Material.PLASTIC);
        assertEquals(Material.PLASTIC, decoration.getMaterial());
    }

    @Test
    void testToString() {
        Decoration decoration = new Decoration(ProdType.DECORATION, "Test Decoration", 10.0, Material.WOOD);
        String expected = "Product [prodId=0, prodType=DECORATION, name=Test Decoration, price=10.0, material=WOOD]";
        assertEquals(expected, decoration.toString());
    }
}
