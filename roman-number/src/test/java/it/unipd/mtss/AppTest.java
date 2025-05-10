////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testAppMainValidInput() {
        System.setOut(new PrintStream(outContent));
        App.checkOutput("42");
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("XLII"));
    }

    @Test
    public void testAppMainInvalidInput() {
        System.setOut(new PrintStream(outContent));
        App.checkOutput("abc");
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("provide a valid integer"));
    }
    
    @Test
    public void testAppMainNoArguments() {
        System.setOut(new PrintStream(outContent));
        App.main(new String[]{});
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("Usage: java App <number>"));
    }

    @Test
    public void testAppMainOutOfRange() {
        System.setOut(new PrintStream(outContent));
        App.checkOutput("0");
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("must be between 1 and 1000"));
    }
}