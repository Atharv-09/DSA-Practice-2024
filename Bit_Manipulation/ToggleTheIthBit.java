package Bit_Manipulation;

// Toggle 
// means if the ith but is 0 make it as 1
// if the ith bit is 1 make it as 0
public class ToggleTheIthBit {
    
    public static int toggleIthBit(int n,int i){

        return (n ^ (1<<i)) ;
    }
    public static void main(String[] args) {
        
        System.out.println(toggleIthBit(13, 1));
    }
}
