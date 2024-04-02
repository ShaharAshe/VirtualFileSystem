package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class PathRow {
    private final ArrayList<Path> filesDicts = new ArrayList<>();

    public void read(){
        ArrayList<String> in = new ArrayList<String>();
        this.readPath(in);
        printPath(in);
    }
    private void readPath(ArrayList<String> in){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        while (!inputPath.equals("exit")){
            in.add(inputPath);
            inputPath = reader.nextLine();
        }
    }

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
