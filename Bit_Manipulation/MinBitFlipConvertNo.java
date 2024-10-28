package Bit_Manipulation;

//Minimum Bit Flips to Convert Number
// A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

/*For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc. */


// start - 10 goal - 7
// 1 0 1 0 
// 0 1 1 1 [count = 3]


public class MinBitFlipConvertNo {
    
    // XOR - TELLS THE DIFFERENTIATING BIT
    // 1 0 1 0 (10)
    // 0 1 1 1 (7)
    // 1 1 0 1 (afetr doing xor as the xor tells the differntiating bit it will give the 1 as bit index)
    // TIEM COMPLEXITY : O(31) [it will check for all the bit]
    static String convertToBinary(int num){
        String ans = "";
        while(num != 1){
            
            if(num%2 == 1) ans = ans +"1";
            else ans = ans +"0";
            num = num/2;
        }
        ans = ans +"1";

        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
    static void minFlipToConvert(int start,int goal){

        int ans = start ^ goal;

        String s = convertToBinary(ans);
        int count = 0;
        for(int i=s.length()-1;i>=0;i--){

            // if(s.charAt(i) == '1') count++;
            if((ans & (1<<i)) !=0 ) count++;

        }
        System.out.println(count);
    }

    // Rather then going for all the bit we can go till the requred bit only 
    static void minFlipToConvert1(int start,int goal){

        int ans = start ^ goal;
        int count = 0;
        while(ans != 0){

            // if(ans % 2 == 1) count++;
            if((ans & 1) == 1) count++; // to check that the bit is 1 or not if 1 then increase the count
            // ans = ans/2;
            ans = ans >> 1; // dividing by 2
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        
        minFlipToConvert(10,7);
    }
}
