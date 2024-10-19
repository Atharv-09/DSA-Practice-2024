package Strings;

import java.util.Stack;
/*REMOVE OUTER PARENTHESIS
 * 
 * Input: s = "(()())(())"
Output: "()()()"
 */
public class RemoveOutermostParanthesis {
    public static String removeOuterParentheses(String s) {
        
        Stack<Character> st = new Stack<>();
        String ans = "";        
        int opened =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == ')'){
                // if thier are more then 1 opened means thier are some mid char also having '('
                // opened is less then 1 means there are only 1 open or less then 1 opened so that may be the outer parenthesis
                if(opened>1) ans = ans +")";
                opened--;
            }else{
                
                if(opened>0) ans = ans + "(";
                opened++;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        
        String s = "(())(())";

        System.out.println(removeOuterParentheses(s));
    }
}
