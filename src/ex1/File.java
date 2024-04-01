package ex1;

public class File implements Path{
    private String fileName;
    int i;

    public File(String str, String tempSt, int iN) throws Exception {
        fileName = tempSt;
        i = iN;
        if(i < str.length()) {
            System.out.printf("File: %s\n", getName());
            add(tempSt, str, i);
        }
    }

    public void add(String prefix, String str, int iN) throws Exception {
        i = iN;
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(prefix);
        if (i == 0 && str.charAt(i) == '/')
            ++i;
        for (; i<str.length(); ++i){
            if (str.charAt(i) != '/'){
                tempStr.append(str.charAt(i));
            }
            else{
                throw new Exception("Cannot add a component to a file.");
            }
        }
    }
    public String getName() {return new String(fileName);}
}
