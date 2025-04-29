package Recursion.A2ZSheet.subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllSubsequencesOfString {

    static void helper(String s,int n,int index,String sub,List<String> ans){

        if(index == n){
            ans.add(sub);
            return;
        }

        sub += s.charAt(index);
        helper(s,n,index+1,sub,ans);
        sub = sub.substring(0,sub.length()-1);
        helper(s,n,index+1,sub,ans);
    }

    // other way

    static void check(String temp, String s){

        if(s.isEmpty()){
            System.out.println(temp);
            return;
        }

        check(temp+s.charAt(0),s.substring(1));
        check(temp,s.substring(1));

    }

    // if you have to return arraylist of this

    static ArrayList<String> subSeqString(String temp, String s){

        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(temp);
            return list;
        }

        ArrayList<String> left = subSeqString(temp+s.charAt(0),s.substring(1));
        ArrayList<String> right = subSeqString(temp,s.substring(1));

        left.addAll(right);
        return left;
    }
    public static void main(String[] args) {
        String s = "abcd";
        List<String> ans = new ArrayList<>();
        helper(s,s.length(),0,"", ans);
        Collections.sort(ans);
        System.out.println(ans);

        // other way
        check("","abcd");

        // collect arraylist
        ArrayList<String> ans2 = subSeqString("","abc");
        System.out.println(ans2);
    }
}
