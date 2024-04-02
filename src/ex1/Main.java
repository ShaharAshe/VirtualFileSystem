package ex1;

public class Main {
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