package Bit_Manipulation;

public class GetIthBit {
    
    public static void main(String[] args) {

        System.out.println(getIthBit(12,1));
    }

    private static int getIthBit(int i, int j) {
        return (1 & (i >> j));
    }
}
