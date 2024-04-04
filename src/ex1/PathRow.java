package ex1;

import java.util.ArrayList;
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
        ArrayList<String> inPath = new ArrayList<>();

        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        while (!inputPath.equals("exit")) {
            inPath.add(inputPath);
            inputPath = reader.nextLine(); // Always read input from the user. until "exit".
        }
        try {
            this.addDictsFiles(inPath);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // print the errors
        }
        this.print(); // print all paths in the end
    }

    private void addDictsFiles(ArrayList<String> inPath){
        for (String in : inPath) {
            try {
                this.root.add(in, 0); // Add new folder/ file to the root path.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // print the errors
            }
        }
    }

    /**
     * Prints all paths.
     */
    public void print(){
        this.root.print();
    }
}