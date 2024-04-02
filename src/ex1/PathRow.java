// PathRow.java
package ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for reading file/directory paths from the user
 * and processing them.
 */
public class PathRow {
    private final ArrayList<Path> filesDicts = new ArrayList<>();

    /**
     * Reads file/directory paths from the user and processes them.
     */
    public void read(){
        ArrayList<String> in = new ArrayList<>();
        this.readPath(in);
        printPath(in);
    }

    /**
     * Reads file/directory paths from the user and adds them to an ArrayList.
     * @param in The ArrayList to store the paths.
     */
    private void readPath(ArrayList<String> in){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        while (!inputPath.equals("exit")){
            in.add(inputPath);
            inputPath = reader.nextLine();
        }
    }

    /**
     * Processes the paths stored in an ArrayList.
     * @param in The ArrayList containing the paths to process.
     */
    private void printPath(ArrayList<String> in){
        boolean isFirst = true;
        for (String s : in) {
            try {
                if (isFirst) {
                    filesDicts.add(new Folder("/root"));
                    isFirst = false;
                }
                filesDicts.get(0).add("/root", s, 0);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
