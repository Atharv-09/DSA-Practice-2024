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
    // ABOVE APPROACH DOES WORD IF WE HAVE MORE SPACES IN WORDS like : 
    // ANOTHER APPROACH
    void reverse(char[] arr,int s,int e){
        // using  2 pointer reverse the string from s to e index
        while(s<=e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            e--;s++;
        }
    }

    void reverseWord(char[] arr,int n){
        // reverse word such the first take 2 pointers and point them to starting and ending index of word
        int i =0,j=0;
        while(j < n){
            while(i<j || i<n && arr[i] == ' ') i++; // if thier is space then increment i
            while(j<i || j<n && arr[j] != ' ') j++; // increment j if its less then i coz 
            // _ _ d l r o w_ _ o l l e h here i is at d(2 index) so increment j such that it comes to w+1(7 index) so we will increment j if its less then i or if the curr char is not null
            // then reverse that word (from ith index which is at d to j-1 index which is at w)
            reverse(arr,i,j-1);
        }
    }

    String removeSpaces(char[] arr,int n){
        int i=0;
        int j = 0;
        // reomve the spaces from the char array
        // i points to first index and j will counter
        while(j<n){
            while(j<n && arr[j] == ' ') j++; // if thier is space increment j
            while(j<n && arr[j] != ' ') arr[i++] = arr[j++]; // if thier is char then add that char to very first index i.e i and increment both indexs
            while(j<n && arr[j] == ' ') j++; // if thier is spaace again then increment j
            if(j<n) arr[i++] = ' '; // add 1 space after each word
        }
        return new String(arr).substring(0,i); // return substring which we pushed from right to left as we reomve spaces
    }
    public String reverseWords2(String s) {
       
       char[] arr = s.toCharArray();
       int n= s.length();
       reverse(arr,0,n-1);// reverse whole string along with the spaces
       reverseWord(arr,n); // now reverse only the words of the string
       return removeSpaces(arr,n); // remove the spaces from the string which are thier in between

    }

    //other approach : 

    public String reverseWords3(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    // same as above but using 2 pointers
    // BEST APPROACH : 
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int i=0,j=arr.length-1;
        while(i<j) {
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return String.join(" ", arr);
    }
    public static void main(String[] args) {
        
        String s = "a good   example";

        System.out.println("*"+reverseString1(s)+"*");
    }
}
