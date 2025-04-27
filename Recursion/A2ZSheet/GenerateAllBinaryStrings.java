package Recursion.A2ZSheet;

import java.util.ArrayList;
import java.util.List;

/*Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

A binary string is that string which contains only 0 and 1.

Example 1:

Input:
N = 3
Output:
000 , 001 , 010 , 100 , 101
Explanation:
None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively. */
public class GenerateAllBinaryStrings {
    static void helper(int n, String str, List<String> ans){

        if(n == str.length()){
            ans.add(str);
            return;
        }

        helper(n,str+"0",ans);
        if(str.isEmpty() || str.charAt(str.length()-1) != '1'){
            helper(n,str+"1",ans);
        }
    }
    /*Time complexity – O(2n)
Space complexity – O(n)*/
    public static List<String> generateBinaryStrings(int n) {
        // code here

        List<String> ans = new ArrayList<>();
        helper(n,"",ans);
        return ans;
    }

    public static void main(String[] args) {

        List<String> ans = generateBinaryStrings(3);
        System.out.println(ans);
    }
}
