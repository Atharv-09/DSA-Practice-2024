package Bit_Manipulation;

public class CountSetBits {
    
    private static int countBit(int n){
        int count = 0;
        while(n!=1){

            // if(n%2 == 1) count++;
            // we can write as n & 1 to check the odd numbers, if thier is some number remaining that means its an odd numer
            //OR

            // if((n&1) != 0) count++;
            // OR
            
            count += n&1; // means n&1 return 1 when the n is odd and return 0 when the n is even
            n = n/2;
        }

        /* BEST USING BIT
        while(n!=1){
            count += n&1; // means n&1 return 1 when the n is odd and return 0 when the n is even
            n = n >> 1; // right shift by 1 means its dividing by 2
        } */
        if(n==1) count++;
        return count;
    }
    public static void main(String[] args) {
        
        System.out.println(countBit(13));
    }
}
