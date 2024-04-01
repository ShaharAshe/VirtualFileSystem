package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Folder implements Path{
    int i;
    private final ArrayList<Path> filesDicts = new ArrayList<Path>();
    public String folderName;
    public Folder(String str) {
        folderName = str;
        i = 0;
    }
    public Folder(String str, String tempSt, int iN) {
        folderName = tempSt;
        i = iN;
        if(i != str.length())
            add(tempSt, str, i);
    }
    public void add(String prefix, String str, int iN){
        i = iN;
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(prefix);
        boolean isFile = false;
        if (str.charAt(i) == '/')
            ++i;
        tempStr.append('/');
        for (; i<str.length(); ++i){
            if (str.charAt(i) != '/'){
                if(str.charAt(i) == '.')
                    isFile = true;
                tempStr.append(str.charAt(i));
            }
            else{
                if (isFile){
                    filesDicts.add(new File(new String(tempStr), str, i));
                }
                else{
                    for (int j = 0; j < filesDicts.toArray().length; ++j) {
                        if (filesDicts.get(j).getName().equals(tempStr)) {
                            filesDicts.get(j).add(new String(tempStr), str, j);
                            return;
                        }
                    }
                    filesDicts.add(new Folder(str, new String(tempStr), i));
                }
            }
        }
        if (isFile){
            filesDicts.add(new File(new String(tempStr), str, i));
        }
        else{
            for (int j = 0; j < filesDicts.toArray().length; ++j) {
                if (filesDicts.get(j).getName().equals(tempStr)) {
                    filesDicts.get(j).add(new String(tempStr), str, j);
                    return;
                }
            }
            filesDicts.add(new Folder(str, new String(tempStr), i));
        }
    }
    public void print(){
        System.out.print("directory: ");
        System.out.println(folderName);
        for (Path fd : filesDicts){
            fd.print();
        }
    }
    /////////////
    public String getName(){return "";}
}
