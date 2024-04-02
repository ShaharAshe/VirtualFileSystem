// Folder.java
package ex1;

import java.util.ArrayList;

/**
 * This class represents a folder in the file system.
 * It implements the Path interface for managing folder paths.
 */
public class Folder implements Path{
    private int i;
    private final ArrayList<Path> filesDicts = new ArrayList<>();
    public String folderName;

    /**
     * Constructs a folder with the given name.
     * @param str The name of the folder.
     */
    public Folder(String str) {
        folderName = str;
        i = 0;
        System.out.printf("Dictionary: %s\n", folderName);
    }

    /**
     * Constructs a folder with the given name and processes the input path.
     * @param str The input path.
     * @param tempSt The temporary string used for processing.
     * @param iN The index used for processing.
     * @throws IllegalArgumentException If the input path is invalid.
     */
    public Folder(String str, String tempSt, int iN) throws IllegalArgumentException {
        folderName = tempSt;
        i = iN;
        System.out.printf("Dictionary: %s\n", folderName);
        if(i < str.length())
            add(tempSt, str, i);
    }

    /**
     * Adds a path to the folder.
     * @param prefix The prefix path.
     * @param str The input path.
     * @param iN The index used for processing.
     * @throws IllegalArgumentException If the input path is invalid.
     */
    @Override
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

    /**
     * Updates the folder with a new path.
     * @param isFile Indicates whether the path is a file.
     * @param tempStr The temporary string representing the path.
     * @param str The input path.
     */
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

    /**
     * Gets the name of the folder.
     * @return The name of the folder.
     */
    @Override
    public String getName(){return new String(folderName);}
}
