package gardenshop;

import org.junit.jupiter.api.Test;

import gardenshop.enums.ProdType;

import static org.junit.jupiter.api.Assertions.*;

public class TcktProdLineTest {
    @Test
    void testTcktProdLine() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        TcktProdLine tcktProdLine = new TcktProdLine(5, product);

        assertEquals(0, tcktProdLine.getNumLine());
        assertEquals(5, tcktProdLine.getProdQtyTicket());
        assertEquals(product, tcktProdLine.getProdTicket());
        assertEquals(10.0, tcktProdLine.getPriceXunit());
        assertEquals(0, tcktProdLine.getTotalPriceProd());
    }

    @Test
    void testSetProdQtyTicket() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        TcktProdLine tcktProdLine = new TcktProdLine(5, product);
        tcktProdLine.setProdQtyTicket(10);

        assertEquals(10, tcktProdLine.getProdQtyTicket());
    }

    @Test
    void testSetProdTicket() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        TcktProdLine tcktProdLine = new TcktProdLine(5, product);
        Product newProduct = new ConcreteProduct(ProdType.DECORATION, "New Product", 20.0);
        tcktProdLine.setProdTicket(newProduct);

        assertEquals(newProduct, tcktProdLine.getProdTicket());
    }

    @Test
    void testSetTotalPriceProd() {
        Product product = new ConcreteProduct(ProdType.DECORATION, "Test Product", 10.0);
        TcktProdLine tcktProdLine = new TcktProdLine(5, product);
        tcktProdLine.setTotalPriceProd(50.0);

        assertEquals(50.0, tcktProdLine.getTotalPriceProd());
    }

}
