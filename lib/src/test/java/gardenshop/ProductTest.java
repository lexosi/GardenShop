package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    void testProdId() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        assertEquals(0, product.getProdId());
    }

    @Test
    void testProdType() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        assertEquals(ProdType.DECORATION, product.getProdType());
    }

    @Test
    void testName() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        assertEquals("Test Product", product.getName());
    }

    @Test
    void testPrice() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        assertEquals(10.0, product.getPrice());
    }

    @Test
    void testSetProdType() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        product.setProdType(ProdType.FLOWER);
        assertEquals(ProdType.FLOWER, product.getProdType());
    }

    @Test
    void testSetName() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        product.setName("New Name");
        assertEquals("New Name", product.getName());
    }

    @Test
    void testSetPrice() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        product.setPrice(20.0);
        assertEquals(20.0, product.getPrice());
    }

    @Test
    void testToString() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        String expected = "Product [prodId=0, prodType=DECORATION, name=Test Product, price=10.0]";
        assertEquals(expected, product.toString());
    }
}

// ConcreteProduct is a concrete subclass of Product that you can instantiate
// for testing
class ConcreteProduct extends Product {
    public ConcreteProduct(ProdType prodType, String name, double price) {
        super(prodType, name, price);
    }
}
