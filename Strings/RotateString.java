package Strings;
/*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
*/
public class RotateString {



    // Brute force 
    // means we are trying to rotate the string by len times and check if they are equal or not 
    // TC : O(N^2)
    public static boolean rotateString(String s, String goal) {
        
        if(s == null || goal == null) return false;
        if(s.length() != goal.length()) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }

        for(int i=0;i<s.length();i++){
            if(rotateStringByI(s,goal,i)) return true;
        }
        return false;

    }

    private static boolean rotateStringByI(String s, String goal, int rotate) {
        int len = goal.length();
        for(int i=0;i<s.length();i++){
            // we are checking for each ith index of string s, if the goal is rotated by rotate value then check all the characters are matching to the string s or not , as if we reach at end of goal string we will go to the first char of goal string
            if(s.charAt(i) != goal.charAt((rotate+i)%len)) return false;
        }   
        return true;
    }


    public static void main(String[] args) {
        
        String s = "abcd";
        String goal = "dbac";

        System.out.println(rotateString(s,goal));
    }
}
