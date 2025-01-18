package Bit_Manipulation;

public class SetTheIthBit {

    // BRUTE FORCE 
    // By converting the number to the binary
    // then setting the ith bit
    // again re converting the decimal string to the binary
    static String convertToBinary(int n){
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
    static int convertToDecimal(String num){
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
    public static String setBit(String s,int i){
        // 1001 
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.replace(len-i-1, len-i, "1");

        return sb.toString();
    }
    public static int setIthBit(int n,int i){

        String s = convertToBinary(n);
        String ss = setBit(s,i);
        // System.out.println(ss);
        int ans = convertToDecimal(ss);
        return ans;
    }

    // ------------------------------------------------------------------
    // BETTER
    // Using OR opertator
    // Taking 
    public static int setIthBit1(int n,int i){
        
        int ans = (n | (1<<i));
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(setIthBit1(12,2));
    }
}
