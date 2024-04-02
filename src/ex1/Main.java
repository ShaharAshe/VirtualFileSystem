package ex1;

public class Main {
    /**
     * The main method creates an instance of PathRow and calls its read method.
     * If an exception occurs during execution, it prints the error message.
     * @param args The command line arguments.
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