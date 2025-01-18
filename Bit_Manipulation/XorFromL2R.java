package Bit_Manipulation;

public class XorFromL2R {
 
    // brute force we will loop from l to r and take the xor of all the number between them
    // TC : O(r-l)

    // Better
    // OBSERVATION : 
    /*N                                 XOR
1  -> 1                           = 1
2  -> 1^2                         = 3
3  -> 1^2^3                       = 0
4  -> 1^2^3^4                     = 4

5  -> 1^2^3^4^5                   = 1
6  -> 1^2^3^4^5^6                 = 7
7  -> 1^2^3^4^5^6^7               = 0
8  -> 1^2^3^4^5^6^7^8             = 8

9  -> 1^2^3^4^5^6^7^8^9           = 1
10 -> 1^2^3^4^5^6^7^8^9^10        = 11
11 -> 1^2^3^4^5^6^7^8^9^10^11     = 0
12 -> 1^2^3^4^5^6^7^8^9^10^11^12  = 12 */

// when n%4 == 1 (return 1)
// when n%4 == 2 (return n+1)
// when n%4 == 3 (return 0)
// when n%4 == 0 (return n)
    // TC : O(1)
    
    public static int func(int n){

        if(n%4 == 1) return 1;
        else if(n%4 == 2) return n+1;
        else if(n%4 == 0) return n;

        return 0;
    }
    public static int findXORofL2R(int l,int r){

        return func(l-1) ^ func(r);
    }
    public static void main(String[] args) {
        
        System.out.println(findXORofL2R(4,8));
    }
}
