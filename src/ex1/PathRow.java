package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class PathRow {
    private final ArrayList<Path> filesDicts;
    private boolean isFirst;

    /**
     * Constructs a PathRow object with an empty collection of paths.
     */
    public PathRow(){
        this.filesDicts = new ArrayList<>();
        this.isFirst = true;
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
                if (this.isFirst) {
                    this.filesDicts.add(new Folder("/root"));
                    this.isFirst = false;
                }
                this.filesDicts.get(0).add("/root", inputPath, 0);
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
        for (Path fd : filesDicts){
            fd.print();
        }
    }
}