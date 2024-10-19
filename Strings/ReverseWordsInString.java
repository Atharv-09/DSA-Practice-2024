package Strings;

import java.util.*;
public class ReverseWordsInString {

    // brute force
    // Using stack TC : O(N) SC : O(words)

    public static String reverseString(String s){

        Stack<String> st = new Stack<>();

        String temp = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(temp!="") st.push(temp); // 
                temp= "";
            }else{
                temp += s.charAt(i);            
            }
        }
        // if thier is word at last 
        if(temp!="") st.push(temp);

        String ans= "";
        while (!st.isEmpty()) {
            ans = ans + st.peek() +" ";
            st.pop();
        }
        return ans;
    }

    // optimal 
    // what we did here, we will traverse character wise 
    //1.  if the ch is empty that means thier will be a word we need to add
    // a. we will check that ans is null that means thier is no word before just copy the temp string into ans
    // s = "atharva is good" , temp = atharva ans = "" , here ans is null then put atharva directly into ans , ans = "atharva"
    // b. now will adding is ans is not null so put "is" before "atharva" i.e ans = temp + " " + ans;

    // 2. is the ch is not empty means appened the string to temp till we reach ch = ' '

    // TC : O(N) SC : O(1)
    public static String reverseString1(String s){

        String temp = "";
        String ans ="";

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(ch != ' '){ // if thier is some character
                temp = temp + ch;
            }else if(ch == ' '){
                if(!ans.equals("")){
                    // is the ans is not empty so addd
                    ans = temp + " "+ ans;
                }else{
                    //if the ans is empty them put them
                    ans = temp;
                }
                temp ="";
            }

        }
        // thier is some string remaining at last word
        if(!temp.equals("")){
            if(!ans.equals("")){
                // ans is having some string
                ans = temp + " " + ans;
            }else{
                ans  =temp;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
        String s = "Her cat's name is pussy and she is so sussy";

        System.out.println(reverseString1(s));
    }
}
