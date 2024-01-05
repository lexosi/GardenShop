package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class FindTest {
    @Test
    void testFindShop() {
        Shop shop1 = new Shop("Shop1");
        Shop shop2 = new Shop("Shop2");
        List<Shop> shops = Arrays.asList(shop1, shop2);

        assertEquals(shop1, Find.findShop(shops, "Shop1"));
        assertEquals(shop2, Find.findShop(shops, "Shop2"));
        assertNull(Find.findShop(shops, "Shop3"));
    }

    @Test
    void testFindProdById() {
        Product product1 = new ConcreteProduct(ProdType.DECORATION, "Product1", 10.0);
        Product product2 = new ConcreteProduct(ProdType.DECORATION, "Product2", 10.0);
        Shop shop = new Shop("Shop1");
        shop.addProduct();
        shop.addProduct();

        assertEquals(product1, Find.findProdById(shop, product1.getProdId()));
        assertEquals(product2, Find.findProdById(shop, product2.getProdId()));
        assertNull(Find.findProdById(shop, 999));
    }
}
