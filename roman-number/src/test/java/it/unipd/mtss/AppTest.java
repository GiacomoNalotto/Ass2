////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.After;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain_ValidInput() {
        App.main(new String[]{"42"});
        assertTrue(outContent.toString().contains("XLII"));
    }

    @Test
    public void testMain_NoArguments() {
        App.main(new String[]{});
        assertTrue(outContent.toString().contains("Usage: java App <number>"));
    }

    @Test
    public void testMain_InvalidInput() {
        App.main(new String[]{"abc"});
        assertTrue(outContent.toString().contains("valid integer"));
    }
}