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
    public void intergerToRomanTest_50()
    {   
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("VI", IntegerToRoman.convert(6));
        assertEquals("VIII", IntegerToRoman.convert(8));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("X", IntegerToRoman.convert(10));
        assertEquals("XI", IntegerToRoman.convert(11));
        assertEquals("XII", IntegerToRoman.convert(12));
        assertEquals("XV", IntegerToRoman.convert(15));
        assertEquals("XVII", IntegerToRoman.convert(17));
        assertEquals("XIX", IntegerToRoman.convert(19));
        assertEquals("XX", IntegerToRoman.convert(20));
        assertEquals("XXIV", IntegerToRoman.convert(24));
        assertEquals("XXV", IntegerToRoman.convert(25));
        assertEquals("XXIX", IntegerToRoman.convert(29));
        assertEquals("XXX", IntegerToRoman.convert(30));
        assertEquals("XXXV", IntegerToRoman.convert(35));
        assertEquals("XXXIX", IntegerToRoman.convert(39));
        assertEquals("XL", IntegerToRoman.convert(40));
        assertEquals("XLVII", IntegerToRoman.convert(47));
        assertEquals("L", IntegerToRoman.convert(50));
        
    }


    @Test
    public void intergerToRomanBoundariesTest_50()
    {
        assertEquals("", IntegerToRoman.convert(-1));
        assertEquals("", IntegerToRoman.convert(0));
        assertEquals("", IntegerToRoman.convert(51));
    }
    
    public int romanToInteger_50(String romanNumeral) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);

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
    public void romanToIntegerTest_50(){
        for(int i = 1; i <= 50; i++){
            assertEquals(i, romanToInteger_50(IntegerToRoman.convert(i)));
        }
    };
}