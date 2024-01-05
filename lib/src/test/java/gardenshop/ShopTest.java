package gardenshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    @Test
    void testShopId() {
        Shop shop = new Shop("Test Shop");
        assertEquals(0, shop.getShopId());
    }

    @Test
    void testName() {
        Shop shop = new Shop("Test Shop");
        assertEquals("Test Shop", shop.getName());
    }

    @Test
    void testProductsStock() {
        Shop shop = new Shop("Test Shop");
        assertTrue(shop.getProductsStock().isEmpty());
    }
}
