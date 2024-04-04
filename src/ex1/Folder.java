package ex1;

import java.util.ArrayList;

/**
 * The Folder class represents a folder in the file system.
 */
public class Folder implements Path{
    private int i; // the index the folder name is start with
    private final ArrayList<Path> filesDicts = new ArrayList<>(); // to save folders/ files that is in the current folder.
    public String folderName;

    /**
     * Default constructor to initialize the root folder.
     */
    public Folder() {
        this.folderName = "/root";
        this.i = 0;
    }

    /**
     * Default constructor to initialize the root folder.
     */
    public Folder(String str, String tempSt, int iN) throws IllegalArgumentException {
        this.folderName = tempSt;
        this.i = iN;
    }

    /**
     * Shell function.
     * Adds a new path to the current folder when its root folder.
     *
     * @param str The path.
     * @param iN The index representing the position in the path.
     * @throws IllegalArgumentException If the addition fails.
     */
    public void add(String str, int iN) throws IllegalArgumentException {
        this.add(this.getName(), str, iN);
    }

    /**
     * Adds a new component to the path.
     *
     * @param prefix The prefix under which the new path component should be added.
     * @param str The new path component to be added.
     * @param iN Additional information about the path component.
     * @throws IllegalArgumentException If the addition cannot be completed.
     */
    @Override
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {
        /* check if we in the end of the path, or we have more folders/ file to add */
        this.i = iN;
        if(this.i >= str.length())
            return;

        StringBuilder tempStr = new StringBuilder();
        tempStr.append(prefix);
        boolean isFile = false;

        /* Examination of extreme cases */
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
        updateAdd(isFile, tempStr, str); // add folder/ file to the current folder.
    }

    /**
     * Updates the folder structure by adding a new folder or file.
     * If the folder or file already exists, it adds the new path component recursively.
     *
     * @param isFile Indicates whether the new component is a file or a folder.
     * @param tempStr The temporary string representing the new component.
     * @param str The full path string.
     */
    private void updateAdd(boolean isFile, StringBuilder tempStr, String str){
        /* check if the folder/ file is already exist */
        for (int j = 0; j < this.filesDicts.toArray().length; ++j) {
            if (this.filesDicts.get(j).getName().contentEquals(tempStr)) {
                if (i<str.length()) // if thar is more in the path. and the file/ folder that we found, is not the last.
                    this.filesDicts.get(j).add(new String(tempStr), str, this.i);
                return;
            }
        }

        /*  if the folder/ file is not exist we creat it */
        if (isFile) // file
            this.filesDicts.add(new File(str, new String(tempStr), this.i));
        else // folder
            this.filesDicts.add(new Folder(str, new String(tempStr), this.i));

        this.filesDicts.get(filesDicts.size()-1).add(new String(tempStr), str, this.i);
    }

    /**
     * Prints information about the folder and its contents.
     */
    @Override
    public void print(){
        System.out.printf("Directory: %s\n", getName());
        for (Path fd : this.filesDicts){
            fd.print();
        }
    }

    /**
     * Gets the name of the folder.
     *
     * @return The name of the folder.
     */
    @Override
    public String getName(){return new String(this.folderName);}
}
