package Bit_Manipulation;
// EX = (13)10 --> (1101)2
public class DecimalToBinary {

    static String getBinary(int num){
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
    public static void main(String[] args) {
        
        System.out.println(getBinary(4));
    }   
}
