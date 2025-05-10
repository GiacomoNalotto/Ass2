////////////////////////////////////////////////////////////////////
// Giacomo Nalotto 2067755
// Giacomo Giora 2101094
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java App <number>");
            return;
        }
        checkOutput(args[0]);
    }

    public static void checkOutput(String input) {
        try {
            int number = Integer.parseInt(input);
            String romanArt = RomanPrinter.print(number);
            
            if (romanArt.isEmpty()) {
                System.out.println("Error: Number must be between 1 and 1000");
            } else {
                System.out.println("ASCII art for Roman number " + 
                    IntegerToRoman.convert(number) + ":");
                System.out.println(romanArt);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide a valid integer");
        }
    }
}