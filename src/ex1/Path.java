// Path.java
package ex1;

/**
 * This interface represents a path in the file system.
 */
public interface Path {
    /**
     * Gets the name of the path.
     * @return The name of the path.
     */
    public String getName();

    /**
     * Adds a path component to the current path.
     * @param prefix The prefix path.
     * @param str The input path component to add.
     * @param iN The index used for processing.
     * @throws IllegalArgumentException If the input path component is invalid.
     */
    public void add(String prefix, String str, int iN) throws IllegalArgumentException;
}
