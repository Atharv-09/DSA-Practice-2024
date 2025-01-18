package Bit_Manipulation;

public class CheckNoIfPowOf2 {
    
    // brute force
    // we can convert into binary string and then check if thier is only 1 set bit then it is the power of 2 otherwise no

    // better
    // as we know the n-1 is the last set bit will be 0 and after that all bit becomes 1
    // 16 = 1 0 0 0 0
    // 15 = 0 1 1 1 1 and after doing and if it is becoming 0 then its power of 2 otherwose No
    public static boolean checkNoPowOf2(int num){

        if((num & num-1) == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
        System.out.println(checkNoPowOf2(64));
    }
}
