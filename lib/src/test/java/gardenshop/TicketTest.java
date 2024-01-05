package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    @Test
    void testTicketId() {
        Ticket ticket = new Ticket();
        assertEquals(0, ticket.getTicketId());
    }

    @Test
    void testProdLines() {
        Ticket ticket = new Ticket();
        assertTrue(ticket.getProdLines().isEmpty());
    }

    @Test
    void testTotalAmount() {
        Ticket ticket = new Ticket();
        assertEquals(0, ticket.getTotalAmount());
    }

    @Test
    void testTotalSaleAmount() {
        Ticket ticket = new Ticket();
        assertEquals(0, ticket.getTotalSaleAmount());
    }

    @Test
    void testAddProd() {
        Ticket ticket = new Ticket();
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ticket.addProd(product, 5);

        assertEquals(1, ticket.getProdLines().size());
        assertEquals(5, ticket.getProdLines().get(0).getProdQtyTicket());
        assertEquals(product, ticket.getProdLines().get(0).getProdTicket());
        assertEquals(50.0, ticket.getProdLines().get(0).getTotalPriceProd());
    }

    @Test
    void testCalculateTotalAmount() {
        Ticket ticket = new Ticket();
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ticket.addProd(product, 5);

        assertEquals(50.0, ticket.calculateTotalAmount());
    }

    @Test
    void testCalculateTotalAmountWTax() {
        Ticket ticket = new Ticket();
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ticket.addProd(product, 5);

        assertEquals(60.5, ticket.calculateTotalAmountWTax());
    }

    @Test
    void testToString() {
        Ticket ticket = new Ticket();
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        ticket.addProd(product, 5);

    String expected = "\t\tSale num: " + ticket.getTicketId() + "\n"
            + "Quantity\tDescription\tPrice/Unit\tTotal\n"
            + ticket.getProdLines() + "\n"
            + "Subtotal:\t\t\t\t\t" + ticket.calculateTotalAmount() + " €\n"
            + "Total price(with 21% tax)\t\t\t" + ticket.calculateTotalAmountWTax() + " €";

    assertEquals(expected, ticket.toString());
}
}
