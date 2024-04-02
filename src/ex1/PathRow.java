package ex1;

import java.util.Scanner;

public class PathRow {
    private Folder root;

    /**
     * Constructs a PathRow object with a root folder representing the root directory.
     */
    public PathRow(){
        this.root = new Folder("/root");
    }

    /**
     * Reads file/directory paths from the user and adds them to the collection.
     */
    public void read(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        while (!inputPath.equals("exit")) {
            try {
                this.root.add("/root", inputPath, 0);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } finally {
                inputPath = reader.nextLine();
            }
        }
        this.print();
    }

    /**
     * Prints all paths stored in the collection.
     */
    public void print(){
        this.root.print();
    }
}