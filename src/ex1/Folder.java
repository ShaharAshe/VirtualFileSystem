package ex1;

import java.util.ArrayList;

public class Folder implements Path{
    private int i;
    private final ArrayList<Path> filesDicts = new ArrayList<>();
    public String folderName;

    /**
     * Constructs a Folder object with the specified name.
     * @param str The name of the folder.
     */
    public Folder(String str) {
        this.folderName = str;
        this.i = 0;
    }

    /**
     * Constructs a Folder object with the specified name and adds it to the path represented by tempSt.
     * @param str The name of the folder.
     * @param tempSt The temporary string representing the path.
     * @param iN An integer representing some aspect of the path.
     * @throws IllegalArgumentException If the addition of the specified string to the path is not valid.
     */
    public Folder(String str, String tempSt, int iN) throws IllegalArgumentException {
        this.folderName = tempSt;
        this.i = iN;
        if(this.i < str.length())
            add(tempSt, str, this.i);
    }

    /**
     * Adds a component to the folder path.
     * @param prefix The prefix of the path.
     * @param str The string to be added to the path.
     * @param iN An integer representing some aspect of the path.
     * @throws IllegalArgumentException If the addition of the specified string to the path is not valid.
     */
    @Override
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {
        this.i = iN;
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(prefix);
        boolean isFile = false;
        if (str.charAt(this.i) == '/') {
            if (str.length() == 1)
                return;
            ++this.i;
        }
        tempStr.append('/');
        for (; this.i<str.length() && str.charAt(this.i) != '/'; ++this.i){
            if(str.charAt(this.i) == '.')
                isFile = true;
            tempStr.append(str.charAt(this.i));
        }
        updateAdd(isFile, tempStr, str);
    }

    /**
     * Updates the collection of paths by adding the new path component.
     * If the path represents a file, it adds it to the collection.
     * If the path represents a folder, it checks if a folder with the same name already exists.
     * If so, it recursively calls add() on that folder.
     * If not, it creates a new folder object and adds it to the collection.
     * @param isFile Indicates whether the path represents a file.
     * @param tempStr The temporary string representing the path.
     * @param str The string to be added to the path.
     */
    private void updateAdd(boolean isFile, StringBuilder tempStr, String str){
        if (isFile){
            this.filesDicts.add(new File(str, new String(tempStr), this.i));
        }
        else{
            for (int j = 0; j < this.filesDicts.toArray().length; ++j) {
                if (this.filesDicts.get(j).getName().contentEquals(tempStr)) {
                    if (i<str.length())
                        this.filesDicts.get(j).add(new String(tempStr), str, this.i);
                    return;
                }
            }
            this.filesDicts.add(new Folder(str, new String(tempStr), this.i));
        }
    }

    /**
     * Prints details about the folder.
     */
    public void print(){
        System.out.print("directory: ");
        System.out.println(getName());
        for (Path fd : this.filesDicts){
            fd.print();
        }
    }

    /**
     * Gets the name of the folder.
     * @return The name of the folder.
     */
    @Override
    public String getName(){return new String(this.folderName);}
}
