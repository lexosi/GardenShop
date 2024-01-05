package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ManageDataTest {
    @Test
    void testLoadData() {
        List<Shop> shops = ManageData.loadData();
        assertTrue(shops.isEmpty()); // Assuming the shops.txt file is initially empty
    }

    @Test
    void testSaveData() {
        List<Shop> shops = List.of(new Shop("Test Shop"));
        ManageData.saveData(shops);

        // Verify that the data was saved correctly
        List<Shop> loadedShops = ManageData.loadData();
        assertEquals(1, loadedShops.size());
        assertEquals("Test Shop", loadedShops.get(0).getName());
    }

    @Test
    void testSaveProduct() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ManageData.saveProduct(product, 5);

        // Verify that the product was saved correctly
        // This would involve reading the stock.txt file and checking its contents
    }

    @Test
    void testSaveTicket() {
        Ticket ticket = new Ticket(); // Assuming Ticket has a default constructor
        ManageData.saveTicket(ticket);

        // Verify that the ticket was saved correctly
        // This would involve reading the tickets.txt file and checking its contents
    }

    @Test
    void testModifyProduct() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ManageData.saveProduct(product, 5);
        ManageData.modifyProduct(product, 10, 5);

        // Verify that the product was modified correctly
        // This would involve reading the stock.txt file and checking its contents
    }

    @Test
    void testDeleteProduct() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ManageData.saveProduct(product, 5);
        ManageData.deleteProduct(product, 5);

        // Verify that the product was deleted correctly
        // This would involve reading the stock.txt file and checking its contents
    }
}
