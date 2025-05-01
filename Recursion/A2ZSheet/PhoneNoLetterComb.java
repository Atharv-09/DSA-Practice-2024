package Recursion.A2ZSheet;

import java.util.ArrayList;
import java.util.List;

public class PhoneNoLetterComb {
    // answer in recursion call itself
    static void find(String un,String p){
        if(un.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = un.charAt(0)-'0'; //converts char into int
        for(int i=(digit-1)*3;i<(digit*3);i++){
            char ch = (char)('a'+i);
            find(un.substring(1),p+ch);
        }
    }
    // or the ans in the recusion body
    // Returning output as Array list
    static ArrayList<String> findList(String un, String p){
        if(un.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> arr = new ArrayList<>();

        int digit = un.charAt(0)-'0'; //converts char into int
        for(int i=(digit-1)*3;i<(digit*3);i++){
            char ch = (char)('a'+i);
            ArrayList<String> prev = findList(un.substring(1),p+ch);
            arr.addAll(prev);
        }
        return arr;
    }
    // find the count of this combinations

    static int countOfComb(String un, String p){

        if(un.isEmpty()) return 1;

        int dig = un.charAt(0)-'0'; // 1-> abc(012)  2-<def
        int start = (dig-1)*3;
        int end = dig*3;
        int count = 0;

        for(int i=start;i<end;i++){
            char ch = (char)('a'+i);
            count += countOfComb(un.substring(1),p+ch);
        }
        return count;
    }
    public static void main(String[] args) {

        String s = "123";
        find(s,"");
//        System.out.println(findList(s,""));
        System.out.println(countOfComb(s,""));
    }
}
