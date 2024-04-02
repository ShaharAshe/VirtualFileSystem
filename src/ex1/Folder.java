package ex1;

import java.util.ArrayList;

public class Folder implements Path{
    private int i;
    private final ArrayList<Path> filesDicts = new ArrayList<>();
    public String folderName;
    public Folder(String str) {
        folderName = str;
        i = 0;
        System.out.printf("Dictionary: %s\n", folderName);
    }
    public Folder(String str, String tempSt, int iN) throws IllegalArgumentException {
        folderName = tempSt;
        i = iN;
        System.out.printf("Dictionary: %s\n", folderName);
        if(i < str.length())
            add(tempSt, str, i);
    }
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {
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
                updateAdd(isFile, tempStr, str);
            }
        }
        updateAdd(isFile, tempStr, str);
    }
    private void updateAdd(boolean isFile, StringBuilder tempStr, String str){
        if (isFile){
            filesDicts.add(new File(str, new String(tempStr), i));
        }
        else{
            for (int j = 0; j < filesDicts.toArray().length; ++j) {
                if (filesDicts.get(j).getName().contentEquals(tempStr)) {
                    if (i<str.length())
                        filesDicts.get(j).add(new String(tempStr), str, i);
                    return;
                }
            }
            filesDicts.add(new Folder(str, new String(tempStr), i));
        }
    }
    /////////////
    public String getName(){return new String(folderName);}
}
