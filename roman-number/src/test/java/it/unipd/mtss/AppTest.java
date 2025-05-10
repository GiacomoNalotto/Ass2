////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    @Test
    public void testAppMainValidInput() {
        App.checkOutput("42");
        fail("This test should fail as checkOutput does nothing");
    }

    @Test
    public void testAppMainInvalidInput() {
        App.checkOutput("abc");
        fail("This test should fail as checkOutput does nothing");
    }
    
    @Test
    public void testAppMainNoArguments() {
        App.checkOutput("a");
        fail("This test should fail as checkOutput does nothing");
    }

    @Test
    public void testAppMainOutOfRange() {
        App.checkOutput("0");
        fail("This test should fail as checkOutput does nothing");
    }
}