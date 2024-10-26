package Bit_Manipulation;
// /K-th Bit is Set or Not
/*Given a number n and a bit number k, check if the kth index bit of n is set or not. A bit is called set if it is 1. The position of set bit '1' should be indexed starting with 0 from the LSB side in the binary representation of the number. */
//n = 4, k = 0 ans = No
// n = 4, k = 2 ans = Yes
// n = 4, k = 12 ans = No 

public class KthBitSetOrNot {
    //Brute Force
    // tc : O(n) + O(logn)
    static String getBinary(int n){
        String ans = "";
        while(n!=1){
            int mod = n%2;
            if(mod == 1) ans = ans+"1";
            else ans = ans + "0";
            n = n/2;
        }
        ans = ans +"1";
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        
        String s = getBinary(n);
        int len = s.length()-1;
        for(int i=len;i>=0;i--){
            if((len-i)==k){
                if(s.charAt(i) == '1'){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }


    // USing left shift
    static boolean checkKthBit1(int n, int k) {

        // we can see that n and 1 << k , thier is some number that means its SET
        // if we get 0 then its NOT SET
        // N = 13 , k =2 --> 1 1 0 1 & 1 0 0 = here we got some number (in binary 1 0 0 ) its SET at index k
        
        if( (n & 1<<k) != 0 ) return true;
        else return false;

    }

    // Using right shift
    static boolean checkKthBit2(int n, int k) {
        
        if(((n >> k) & 1) != 0) return true;
        else return false; // not set
    }
    public static void main(String[] args) {
        
        System.out.println(checkKthBit2(10, 2));
    }
}
