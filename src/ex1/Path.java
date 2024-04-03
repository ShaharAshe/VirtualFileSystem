package ex1;

/**
 * The Path interface represents a path in the file system.
 */
public interface Path {
    /**
     * Prints information about the path.
     */
    public void print();

    /**
     * Gets the name of the path.
     *
     * @return The name of the path.
     */
    public String getName();

    /**
     * Adds a new component to the path.
     *
     * @param prefix The prefix under which the new path component should be added.
     * @param str The new path component to be added.
     * @param iN Additional information about the path component.
     * @throws IllegalArgumentException If the addition cannot be completed.
     */
    public void add(String prefix, String str, int iN) throws IllegalArgumentException;
}
