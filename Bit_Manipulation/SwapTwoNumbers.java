package Bit_Manipulation;
// swap two numebr without using the third temp vairable

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapTwoNumbers {

    static List<Integer> swapNum(int a,int b){

        a = a^b;
        b = a^b; // (a^b)^b = a
        a = a^b; // (a^b)^a = b

        return new ArrayList<>(Arrays.asList(a,b));
    }
    public static void main(String[] args) {
        
        int a = 10;
        int b = 11;
        System.out.println(a +" " + b);
        List<Integer> ans = swapNum(a,b);
        System.out.println(ans.get(0) +" " + ans.get(1));
    }
}
