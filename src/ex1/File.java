package ex1;

/**
 * The File class represents a file in the file system.
 */
public class File implements Path{
    private String fileName;

    /**
     * Constructor with custom name and index.
     *
     * @param str The path.
     * @param tempSt The temporary string representing the file name.
     * @param iN The index representing the position in the path.
     * @throws IllegalArgumentException If the initialization fails.
     */
    public File(String str, String tempSt, int iN) throws IllegalArgumentException {
        this.fileName = tempSt;
    }

    /**
     * check if we in the end of the path, or we have more folders/ file. if thar is throw an Exception
     *
     * @param prefix The prefix under which the new path component should be added.
     * @param str The new path component to be added.
     * @param iN Additional information about the path component.
     * @throws IllegalArgumentException If the addition cannot be completed.
     */
    @Override
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {
        /* check if we in the end of the path, or we have more folders/ file. if thar is throw an Exception */
        if (iN < str.length())
            throw new IllegalArgumentException("Error in Path: "+str+"\nCannot add a component to a file.");
    }

    /**
     * Prints information about the file.
     */
    @Override
    public void print() {
        System.out.printf("File: %s\n", getName());
    }

    /**
     * Gets the name of the file.
     *
     * @return The name of the file.
     */
    @Override
    public String getName() {return new String(this.fileName);}
}
