package ex1;

public class File implements Path{
    private String fileName;
    int i;

    public File(String str, String tempSt, int iN){
        this.fileName = str;
        i = iN;

        add(tempSt, str, i);
    }

    public void add(String prefix, String str, int iN){
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
                System.out.println("error!");
            }
        }
    }
    public void print() {
        System.out.print("File: ");
        System.out.println(fileName);}
    public String getName() {return "";}
}
