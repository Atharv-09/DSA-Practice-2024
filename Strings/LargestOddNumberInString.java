package Strings;
/*ou are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.
1. num = "52"  op = "5"
2. num = "4206" op =""
3. num = "233788" op = "2337"
4. num = "25793" op = "25793"
*/
public class LargestOddNumberInString {
    
    // Brute force
    // take 2 for loops where out loop denotes start of sustring and inner loop end of substring;
    // take the max var and check if that substring is odd and greater then max, make that substring as max;

    //TC : O(N^2) [2 for loops]

    //---------------------------------------------------------------------------

    // OPTIMAL 
    // As we know that we want odd max substring so basically odd no has the righ most element as the odd element
    // traverse from right to left and check if the ch is odd elemenet, YES then return substring from start to currOddIndex
    // TC : O(N)+O(N) 

    static String findLargestNo(String s){

         int n = s.length();
        int index = -1;
         for(int i=n-1;i>=0;i--){

            int number = s.charAt(i)-'0';
            if(number %2 != 0){
                index = i;
                break;
            }
         }

        return s.substring(0, index+1);
    }
    public static void main(String[] args) {
        
        String s = "3684";
        System.out.println(findLargestNo(s));
    }
}
