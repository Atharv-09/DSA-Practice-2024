package Strings;
/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

1.strs = ["flower","flow","flight"]
Output: "fl"

2.strs = ["dog","racecar","car"]
Output: ""
*/
import java.util.*;
public class LongestCommonPrefix {

    // BRUTE FORCE
    // By taking 1 string and checking for the others strings in array is thier character are same or not
    // TC : O(X*N) (x-length of 1st string and N is the length of array give)

    public static String longestCommonPrefix(String[] strs) {
        
        String s = strs[0];
        String ans = "";
        for(int k=0;k<s.length();k++){
            int count =0;
            for(int i=1;i<strs.length;i++){
                
                if(k<strs[i].length()){
                    char ch = strs[i].charAt(k);
                    if(s.charAt(k) == ch) count++;
                    else break;
                }
            }

            if(count == strs.length-1)
                ans = ans + s.charAt(k);
            else break;
        }

        return ans;
    }

    // Optimal
    // Instead of checking each string we can say that if we sort the string lexiographically
    // i.e ["cow","catoo","cyan","cat"] --> ["cat","catoo","caw","cyan"]
    // Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
    // we will iterate the chars of first and last string and stop at the length of shorted string 

    // TC : O(nlogn) + O(l)(l is minlength of sorted first and last string)
    public static String longestCommonPrefix1(String[] strs) {

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        String ans="";

        int minLen = Math.min(first.length(),last.length());
        for(int i=0;i<minLen;i++){
            if(first.charAt(i) == last.charAt(i))
                ans = ans + first.charAt(i);
            else break;
        }
        return ans; 

    }
    public static void main(String[] args) {
        
        System.out.println(longestCommonPrefix(new String[]{"flower","fl","fajasa"}));
    }
}

/*Initialize an empty string ans to store the common prefix.
Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
Iterate through the characters of the first and last string in the sorted list, stopping at the length of the shorter string.
If the current character of the first string is not equal to the current character of the last string, return the common prefix found so far.
Otherwise, append the current character to the ans string. */