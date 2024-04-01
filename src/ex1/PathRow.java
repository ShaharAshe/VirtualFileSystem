package ex1;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Scanner;

public class PathRow {
    private final ArrayList<Path> filesDicts = new ArrayList<Path>();
    public void readPath(){
        Scanner reader = new Scanner(System.in);
        boolean isFirst = true;
        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        String inputPath = reader.nextLine();
        do {
            if(isFirst) {
                filesDicts.add(new Folder("/root"));
                isFirst = false;
            }
            filesDicts.get(0).add("/root", inputPath, 0);
            inputPath = reader.nextLine();
        } while (!inputPath.equals("exit"));
        System.out.println("--------------------");
        print();
    }
    public void print(){
        for (Path fd : filesDicts){
            fd.print();
        }
    }
}
