////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;
import java.lang.reflect.*;

public class RomanPrinterTest {
    
    private RomanPrinter printer;
    private Method privatePrintMethod;
    
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); 
    
    @Before
    public void initialize() throws NoSuchMethodException {
        printer = new RomanPrinter();
        privatePrintMethod = RomanPrinter.class.getDeclaredMethod("printAsciiArt", String.class);
        privatePrintMethod.setAccessible(true);
    }
    
    private String invokePrivatePrint(String input) {
        try {
            return (String) privatePrintMethod.invoke(printer, input);
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Failed to invoke private method: " + e.getMessage());
            return null;
        }
    }
    
    @Test
    public void publicPrintShouldReturnNonEmptyForValidInput() {
        assertNotNull("Output should not be null", RomanPrinter.print(1));
        assertFalse("Output should not be empty", RomanPrinter.print(1).isEmpty());
    }
    
    @Test
    public void publicPrintShouldHandleInvalidNumbers() {
        assertEquals("Should return empty for 0", "", RomanPrinter.print(0));
        assertEquals("Should return empty for negative", "", RomanPrinter.print(-1));
    }
    
    @Test
    public void privateMethodShouldHandleEdgeCases() {
        assertEquals("Empty input should return empty", "", invokePrivatePrint(""));
        assertEquals("Null input should return empty", "", invokePrivatePrint(null));
        assertEquals("Invalid roman should return empty", "", invokePrivatePrint("A"));
    }
    
    @Test
    public void massTestNumbersFrom1To1000() {
        StringBuilder results = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            String output = RomanPrinter.print(i);
            assertNotNull("Output for " + i + " should not be null", output);
            results.append(output).append("- ").append(i).append("\n");
        }
        //System.out.println(results.toString());
    }
}