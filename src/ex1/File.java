package ex1;

public class File implements Path{
    private String fileName;
    public File(String str, String tempSt, int iN) throws IllegalArgumentException {
        fileName = tempSt;
        System.out.printf("File: %s\n", getName());
        if(iN < str.length()) {
            throw new IllegalArgumentException("Cannot add a component to a file.");
        }
    }
    public void add(String prefix, String str, int iN) throws IllegalArgumentException {}
    public String getName() {return new String(fileName);}
}
