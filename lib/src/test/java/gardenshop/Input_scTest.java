package gardenshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

public class Input_scTest {
    @Test
    void testEnterStr() {
        String input = "Test String\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals("Test String", Input_sc.enterStr("Enter a string:"));
    }

    @Test
    void testEnterInt() {
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(10, Input_sc.enterInt("Enter an integer:"));
    }

    @Test
    void testEnterByte() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(5, Input_sc.enterByte("Enter a byte:"));
    }

    @Test
    void testEnterDouble() {
        String input = "3.14\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(3.14, Input_sc.enterDouble("Enter a double:"), 0.001);
    }

    @Test
    void testReadChar() {
        String input = "c\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals('c', Input_sc.readChar("Enter a character:"));
    }
}
