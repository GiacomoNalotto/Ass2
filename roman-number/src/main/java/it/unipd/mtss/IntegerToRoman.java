////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;
  
public class IntegerToRoman {
    private static final int[] values = {10, 9, 5, 4, 1};
    private static final String[] symbols = {"X", "IX", "V", "IV", "I"};
    
    public static String convert(int number) {
        if (number <= 0 || number > 10) {
            return "";
        }
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++){
            while (values[i] <= number) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }
}