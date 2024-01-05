package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    void testTreeConstructorAndGetters() {
        Tree tree = new Tree(ProdType.TREE, "Test Tree", 10.0, 5.0);

        assertEquals(ProdType.TREE, tree.getProdType());
        assertEquals("Test Tree", tree.getName());
        assertEquals(10.0, tree.getPrice());
        assertEquals(5.0, tree.getHeight());
    }

    @Test
    void testSetHeight() {
        Tree tree = new Tree(ProdType.TREE, "Test Tree", 10.0, 5.0);
        tree.setHeight(10.0);

        assertEquals(10.0, tree.getHeight());
    }

}
