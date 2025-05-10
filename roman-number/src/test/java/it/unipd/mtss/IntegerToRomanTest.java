////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Before;

public class IntegerToRomanTest 
{
    IntegerToRoman integerToRoman;

    @Before
    public void setUp(){
        integerToRoman = new IntegerToRoman();
    }
    
    @Test
    public void intergerToRomanTest_3()
    {   
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("III", IntegerToRoman.convert(3));
    }


    @Test
    public void intergerToRomanNegativeTest_3()
    {
        assertEquals("", IntegerToRoman.convert(-3));
        assertEquals("", IntegerToRoman.convert(0));
    }
    
    public int romanToInteger_3(String romanNumeral) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);

        int result = 0;
        int prevValue = 0;
    
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentChar = romanNumeral.charAt(i);
            int currentValue = romanValues.get(currentChar);
    
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
    
            prevValue = currentValue;
        }
    
        return result;
    }
    
    @Test(timeout = 1000)
    public void romanToIntegerTest_3(){
        for(int i = 1; i <= 3; i++){
            assertEquals(i, romanToInteger_3(IntegerToRoman.convert(i)));
        }
    };
}