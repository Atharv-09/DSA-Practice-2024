package Strings;

/*Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result. */

public class StringToInteger {

    // NORMAL
    public static int myAtoi(String s) {
        
        int i=0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        s = s.substring(i);
        if(s.length() == 0) return 0;
        int sign=1;
        int ans =0;
        int min = Integer.MIN_VALUE,max=Integer.MAX_VALUE;

        // checknig the sign +Ve or -ve
        if(s.charAt(0) == '-') sign = -1;

        // if thier is negative sign we will start from 1st index
        i = (s.charAt(0) == '-' || s.charAt(0)=='+') ? 1 : 0;

        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' ' || !Character.isDigit(ch))
                break;
            int digit=(ch-'0');
            if(ans > (max / 10) || (ans == (max / 10) && digit > 7)){
                    return sign==-1 ? min : max;
            }            
            ans = ans * 10 +  digit; // to convert into integer
            // if(sign == -1 && -1*ans < min) return min;
            // if(sign == 1 && (1*ans > (max/10))) return max;
            
            i++;
        }

    return sign*ans;
    }

    // RECURSIVE

    public static int myAtoi1(String s,int n){
        // If str is NULL or str contains non-numeric
    // characters then return 0 as the number is not
    // valid
        if (s == "" || !s.matches("^\\d*$")) {
            return 0;
        }
        //only ine int
        if(n == 1) return s.charAt(0)-'0';

        int ans = myAtoi1(s,n-1);
// If more than 1 digits, recur for (n-1), 
    // multiply result with 10 and add last digit
        return ans*10 + (s.charAt(n)-'0');

    }

    public static void main(String[] args) {
        String s =" a123";
        System.out.println(myAtoi1(s,s.length()-1));
    }
    
}
