package gardenshop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuMngmtTest {
    @Test
    void testAddProductToStock() {
        Shop shop = Mockito.mock(Shop.class);
        MenuMngmt.addProductToStock(shop);
        Mockito.verify(shop).addProduct();
    }
}
