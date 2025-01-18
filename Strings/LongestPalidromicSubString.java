package Strings;
/*Given a string s, return the longest 
palindromic
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
  */
public class LongestPalidromicSubString {
    // brute force to take 3 loops and take each substring and check is that palindromic
    // TC : O(N*N*N)


    // brute force by checkin each substring
    // TC : O(n*n) + O(logn)
    boolean checkP(char[] arr){
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            if(arr[l]!=arr[r]) return false;
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        
        char[] arr = s.toCharArray();
        int maxL = 0;String ans="";
        for(int i=0;i<arr.length;i++){
            String subStr = "";
            for(int j=i;j<arr.length;j++){
                subStr += arr[j];
                if(checkP(subStr.toCharArray()) && subStr.length() > maxL){
                    maxL = subStr.length();
                    ans = subStr;
                    //OR
                    // instead subStr variable, in condition add  j-i > maxL 
                    // and ans = s.substring(i,j-i);
                }
            }
        }
        return ans;
    }

    // Using 2 pointers such that we will consider character of string and from that char our 2 pointer go left and right
    // if the char are same pointer will go left and right accordingly till we have palindrome
    // then we will store that substring and check if its length greater then max palindromic substring
    // so thier might we case if we haev odd no of character we will go from mid to left and right
    // like madam from d we can go left and right both but for
    // EXAMPLE : carrac suppose we are at r index so if we check for left and right we will miss out longest palindrom so another check where low points to index-1 and high to index
    // such that for 1st r low at a and high at r it will not give palindrome
    // for 2nd r low point to first r and high point to second r such that we have high palinrome string

    public static String longestPalindromeusing2pointer(String s) {

        if(s.length() <=1) return s;
        String lps = "";

        for(int i=1;i<s.length();i++){

            int low = i;
            int high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == s.length()) break;
            }

            String subStr = s.substring(low+1, high);
            if(subStr.length() > lps.length()){
                lps = subStr;
            }

            low = i-1;
            high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == s.length()) break;
            }

            subStr = s.substring(low+1, high);
            if(subStr.length() > lps.length()){
                lps = subStr;
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        
        System.out.println(longestPalindromeusing2pointer("ABRBADAADAB"));
    }
}
