package Bit_Manipulation;

// given n = 13 , i =2
// 1 1 0 1 -> we have to make the 2nd bit as 0 
// 1 0 0 1 
// if the ith bit is 0 make as it is and if its 1 make it as 0
// we can use brute force 
public class ClearTheIthBit {
    
    // brute force 
    // by converting the binary to decimal
    // then loop to the ith index from last and then unset the ith bit
    // again covert back the decimal to binary


    // better
    // AND
    // 1 1 0 1
    // 0 1 0 0 (we can do left shift of 1 by k then we will negate this to get the 1 0 1 1)
    // 1 0 1 1 (then we will and this and the n)
    
    public static int cleartIthBit(int n,int i){

        return (n & ~(1<<i)) ;
    }
    public static void main(String[] args) {
        
        System.out.println(cleartIthBit(13, 2));
    }
}
