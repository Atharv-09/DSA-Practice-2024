package Recursion.A2ZSheet;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParenthesis {


    void helper(String s, int open, int close, int n, List<String> ans){

        if(open == close && open == n){
            ans.add(s);
            return;
        }
        // other base condition we can add like if s.length == n*2
//        if(close>open) return;
        if(open<n)
            helper(s+"(",open+1,close,n,ans);

        // either at below we can add condition as close < n and at above uncomment close>open or we do like this below
        if(close<open)
            helper(s+")",open,close+1,n,ans);
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        helper("",0,0,n,ans);
        return ans;
    }

    public static void main(String[] args) {

        List<String> ans = new GenerateAllParenthesis().generateParenthesis(3);
        System.out.println(ans);
    }
}
