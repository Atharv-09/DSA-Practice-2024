package Bit_Manipulation;

// n = 1 1 0 1 
// remove the last set bit 
// n = 1 1 0 0 -> ans (12)

public class RemoveTheLastSetBit {
    
    static int removeLastSetBit(int n){

        // brute force means we can convert to binary then loop from last to digit till we et '1' make it as '0' again convert ack to decimal and return
        // optimal
        // as we observce that n-1 it becomes the last set digit of n as 0 and after that all digit as 1
        // 40 = 1 0 1 0 0 0 = 2^5 + 2^3 = 32 + 8
        // 39 = 1 0 0 1 1 1 = 2^5 + (8-1 = 7 (2^2 + 2^1 + 2^0))
        // making and of both we get the last set bit removed of n

        return n & n-1;
        
    }
    public static void main(String[] args) {
        
        System.out.println(removeLastSetBit(40));
    }
}
