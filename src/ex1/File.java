package ex1;

public class File implements Path{
    private String fileName;

    /**
     * Constructs a File object with the specified name.
     * @param str The name of the file.
     * @param tempSt The temporary string representing the path.
     * @param iN An integer representing some aspect of the path.
     * @throws IllegalArgumentException If the addition of the specified string to the path is not valid.
     */
    public File(String str, String tempSt, int iN) throws IllegalArgumentException {
        this.fileName = tempSt;
        if(iN < str.length()) {
            throw new IllegalArgumentException("Error in Path: "+str+"\nCannot add a component to a file.");
        }
    }

    /**
     * Adds a component to the file path.
     * This method has an empty implementation as files cannot have components added to them.
     * @param prefix The prefix of the path.
     * @param str The string to be added to the path.
     * @param iN An integer representing some aspect of the path.
     * @throws IllegalArgumentException If the addition of the specified string to the path is not valid.
     */
    @Override
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {}

    /**
     * Prints details about the file.
     */
    public void print() {
        System.out.print("File: ");
        System.out.println(getName());
    }

    /**
     * Gets the name of the file.
     * @return The name of the file.
     */
    @Override
    public String getName() {return new String(this.fileName);}
}
