package Strings;

public class Demo {

    static void removeSpace(String s){
        String withoutSpace = "";
        for(Character ch: s.toCharArray()){
            if(ch != ' '){
                withoutSpace+=ch;
            }
        }
        System.out.println(withoutSpace);
    }
    public static void main(String[] args) {
        String s = "Suraj weds Anjali";
        removeSpace(s);
    }
}
