package gardenshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuTest {
    @Test
    void testStartApp() {
        String input = "Test Shop\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu menu = new Menu();
        menu.startApp();

        String expectedOutput = "Enter the name of your Garden Shop to register it"
                + "Garden Shop create successfully\n"
                + "Welcome to the Test Shop Shop App Menu"
                + "\nGARDEN SHOP APP MENU\n"
                + "----------------------------------------------------------\n"
                + "Choose one of the following options (enter its number)\n"
                + "1. Add Tree, Flower or Decoration to the shop's stock\n"
                + "2. Remove Tree, Flower or Decoration from the shop's stock\n"
                + "3. Show the stock of all products\n"
                + "4. Show stock quantities\n"
                + "5. Show total value of the Garden shop\n"
                + "6. Create sale's ticket with multiple objects\n"
                + "7. Show old sale's tickets\n"
                + "8. Show total amount made from sales\n"
                + "0. Quit the app";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void testShowMenu() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        byte option = Menu.showMenu();
        assertEquals(0, option);
    }
}
