////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

public class RomanPrinter {
    private static final String[] I_ART = {
        "  _____  ",
        " |_   _| ",
        "   | |   ",
        "   | |   ",
        "  _| |_  ",
        " |_____| "
    };
    
    private static final String[] V_ART = {
        " __      __ ",
        " \\ \\    / / ",
        "  \\ \\  / /  ",
        "   \\ \\/ /   ",
        "    \\  /    ",
        "     \\/     "
    };
    
    private static final String[] X_ART = {
        " __   __ ",
        " \\ \\ / / ",
        "  \\ V /  ",
        "   > <   ",
        "  / . \\  ",
        " /_/ \\_\\ "
    };
    
    private static final String[] L_ART = {
        "  _       ",
        " | |      ",
        " | |      ",
        " | |      ",
        " | |____  ",
        " |______| "
    };
    
    private static final String[] C_ART = {
        "   _____  ",
        "  / ____| ",
        " | |      ",
        " | |      ",
        " | |____  ",
        "  \\_____| "
    };
    
    private static final String[] D_ART = {
        "  _____   ",
        " |  __ \\  ",
        " | |  | | ",
        " | |  | | ",
        " | |__| | ",
        " |_____/  "
    };
    
    private static final String[] M_ART = {
        "  __  __  ",
        " |  \\/  | ",
        " | \\  / | ",
        " | |\\/| | ",
        " | |  | | ",
        " |_|  |_| "
    };

    public static String print(int num) {
        String roman = IntegerToRoman.convert(num);
        return printAsciiArt(roman);
    }
  
    public static String printAsciiArt(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty()) {
            return "";
        }
        
        StringBuilder[] lines = new StringBuilder[6];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new StringBuilder();
        }
        
        for (char c : romanNumber.toCharArray()) {
            String[] art = getArtForChar(c);
            if (art == null) {
                return "";
            }
            
            for (int i = 0; i < art.length; i++) {
                lines[i].append(art[i]);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder line : lines) {
            result.append(line.toString()).append("\n");
        }
        
        return result.toString();
    }
    
    public static String[] getArtForChar(char c) {
        switch (Character.toUpperCase(c)) {
            case 'I': return I_ART;
            case 'V': return V_ART;
            case 'X': return X_ART;
            case 'L': return L_ART;
            case 'C': return C_ART;
            case 'D': return D_ART;
            case 'M': return M_ART;
            default: return null;
        }
    }
}