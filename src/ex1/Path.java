package ex1;

public interface Path {
    public String getName();
    public void add(String prefix, String str, int iN) throws IllegalArgumentException;
}
