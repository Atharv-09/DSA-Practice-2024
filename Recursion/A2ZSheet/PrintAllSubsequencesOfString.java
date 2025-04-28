package Recursion.A2ZSheet;

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
    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        helper(s,s.length(),0,"", ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
