// Main.java
package ex1;

/**
 * This class contains the main method to execute the program.
 */
public class Main {
    /**
     * The main method of the program.
     * It instantiates a PathRow object and calls its read() method.
     * Any exceptions thrown during execution are caught and printed.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            PathRow filesDicts = new PathRow();
            filesDicts.read();
        }
        catch (Exception e){
            System.out.printf("Error: %s",e.getMessage());
        }
    }
}