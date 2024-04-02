// File.java
package ex1;

/**
 * This class represents a file in the file system.
 * It implements the Path interface for managing file paths.
 */
public class File implements Path{
    private String fileName;

    /**
     * Constructs a file with the given name.
     * @param str The name of the file.
     * @param tempSt The temporary string used for processing.
     * @param iN The index used for processing.
     * @throws IllegalArgumentException If any components are added to the file.
     */
    public File(String str, String tempSt, int iN) throws IllegalArgumentException {
        fileName = tempSt;
        System.out.printf("File: %s\n", getName());
        if(iN < str.length()) {
            throw new IllegalArgumentException("Cannot add a component to a file.");
        }
    }

    /**
     * Adds a path to the file.
     * Since files cannot have sub-components, this method does nothing.
     * @param prefix The prefix path.
     * @param str The input path.
     * @param iN The index used for processing.
     * @throws IllegalArgumentException If any components are added to the file.
     */
    @Override
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {}

    /**
     * Gets the name of the file.
     * @return The name of the file.
     */
    @Override
    public String getName() {return new String(fileName);}
}
