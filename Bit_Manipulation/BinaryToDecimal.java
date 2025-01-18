package Bit_Manipulation;
// 
// [1100]10 =  (12)2

public class BinaryToDecimal {
    
    static int getDecimal(String num){
        int len = num.length()-1;
        int power = 1;int ans=0;
        for(int i=len;i>=0;i--){

            if(num.charAt(i) == '1'){ // fi thier is one that only we can consider
                ans = ans + power;
            }
            power = power * 2; // we are increasing the 2 raise to power for every intervals [1*2^3 + 0*2^2 + 1*2^1 + 0*2^0]
        }
        return ans;
    }
    public static void main(String[] args) {
        
        System.out.println(getDecimal("1010"));
    }   
}