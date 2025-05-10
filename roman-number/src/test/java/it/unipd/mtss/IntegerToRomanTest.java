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
    public void intergerToRomanTest_500()
    {   
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("VIII", IntegerToRoman.convert(8));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("X", IntegerToRoman.convert(10));
        assertEquals("XI", IntegerToRoman.convert(11));
        assertEquals("XV", IntegerToRoman.convert(15));
        assertEquals("XVII", IntegerToRoman.convert(17));
        assertEquals("XIX", IntegerToRoman.convert(19));
        assertEquals("XX", IntegerToRoman.convert(20));
        assertEquals("XXIV", IntegerToRoman.convert(24));
        assertEquals("XXX", IntegerToRoman.convert(30));
        assertEquals("XXXV", IntegerToRoman.convert(35));
        assertEquals("XXXIX", IntegerToRoman.convert(39));
        assertEquals("XL", IntegerToRoman.convert(40));
        assertEquals("XLVII", IntegerToRoman.convert(47));
        assertEquals("L", IntegerToRoman.convert(50));
        assertEquals("LIV", IntegerToRoman.convert(54));
        assertEquals("LIX", IntegerToRoman.convert(59));
        assertEquals("LX", IntegerToRoman.convert(60));
        assertEquals("LXX", IntegerToRoman.convert(70));
        assertEquals("LXXIII", IntegerToRoman.convert(73));
        assertEquals("LXXX", IntegerToRoman.convert(80));
        assertEquals("XC", IntegerToRoman.convert(90));
        assertEquals("XCV", IntegerToRoman.convert(95));
        assertEquals("XCIX", IntegerToRoman.convert(99));
        assertEquals("C", IntegerToRoman.convert(100));
        assertEquals("CXL", IntegerToRoman.convert(140));
        assertEquals("CL", IntegerToRoman.convert(150));
        assertEquals("CC", IntegerToRoman.convert(200));
        assertEquals("CCL", IntegerToRoman.convert(250));
        assertEquals("CCC", IntegerToRoman.convert(300));
        assertEquals("CD", IntegerToRoman.convert(400));
        assertEquals("CDXCIX", IntegerToRoman.convert(499));
        assertEquals("D", IntegerToRoman.convert(500));
        
    }


    @Test
    public void intergerToRomanBoundariesTest_500()
    {
        assertEquals("", IntegerToRoman.convert(-1));
        assertEquals("", IntegerToRoman.convert(0));
        assertEquals("", IntegerToRoman.convert(501));
    }
    
    public int romanToInteger_500(String romanNumeral) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);

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
    public void romanToIntegerTest_500(){
        for(int i = 1; i <= 500; i++){
            assertEquals(i, romanToInteger_500(IntegerToRoman.convert(i)));
        }
    };
}