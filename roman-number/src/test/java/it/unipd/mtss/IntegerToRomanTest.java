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
    public void intergerToRomanTest_20()
    {   
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("II", IntegerToRoman.convert(2));
        assertEquals("III", IntegerToRoman.convert(3));
        assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("VI", IntegerToRoman.convert(6));
        assertEquals("VII", IntegerToRoman.convert(7));
        assertEquals("VIII", IntegerToRoman.convert(8));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("X", IntegerToRoman.convert(10));
        assertEquals("XI", IntegerToRoman.convert(11));
        assertEquals("XII", IntegerToRoman.convert(12));
        assertEquals("XV", IntegerToRoman.convert(15));
        assertEquals("XVII", IntegerToRoman.convert(17));
        assertEquals("XIX", IntegerToRoman.convert(19));
        assertEquals("XX", IntegerToRoman.convert(20));
        
    }


    @Test
    public void intergerToRomanBoundariesTest_20()
    {
        assertEquals("", IntegerToRoman.convert(-1));
        assertEquals("", IntegerToRoman.convert(0));
        assertEquals("", IntegerToRoman.convert(21));
    }
    
    public int romanToInteger_20(String romanNumeral) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);

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
    public void romanToIntegerTest_20(){
        for(int i = 1; i <= 20; i++){
            assertEquals(i, romanToInteger_20(IntegerToRoman.convert(i)));
        }
    };
}