package ex1;

public interface Path {
    /**
     * Prints details about the path.
     */
    public void print();

    /**
     * Gets the name of the path.
     * @return The name of the path.
     */
    public String getName();

    /**
     * Adds a component to the path.
     * @param prefix The prefix of the path.
     * @param str The string to be added to the path.
     * @param iN An integer representing some aspect of the path.
     * @throws IllegalArgumentException If the addition of the specified string to the path is not valid.
     */
    public void add(String prefix, String str, int iN) throws IllegalArgumentException;
}
