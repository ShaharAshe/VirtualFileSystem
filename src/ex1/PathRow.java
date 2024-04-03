package ex1;

import java.util.Scanner;

/**
 * The PathRow class manages paths input by the user.
 */
public class PathRow {
    private final Folder root;

    /**
     * Initializes the PathRow with a root folder.
     */
    public PathRow(){
        this.root = new Folder();
    } // Initialized the root folder.

    /**
     * Reads paths input by the user and processes them.
     */
    public void read(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        while (!inputPath.equals("exit")) {
            try {
                this.root.add(inputPath, 0); // Add new folder/ file to the root path.
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage()); // print the errors
            } finally {
                inputPath = reader.nextLine(); // Always read input from the user. until "exit".
            }
        }
        this.print(); // print all paths in the end
    }

    /**
     * Prints all paths.
     */
    public void print(){
        this.root.print();
    }
}