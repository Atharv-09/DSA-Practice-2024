package Recursion;

public class NumberRecursion {

    static int sumDigits(int x){
        if(x == 0) return 0;

        return x%10 + sumDigits(x/10);
    }
    static int multiplyDigits(int x){
        if(x == 0) return 1;

        return x%10 * multiplyDigits(x/10);
    }

    static int sum = 0;
    static void reverseNumber(int x){
        if(x <= 0){
            System.out.println(sum);
            return;
        }
        int rem = x%10;
        sum = sum *10 + rem;
        reverseNumber(x/10);
    }
    // or reverse numebr using argument
    static int helper(int x,int dig){

        if(x%10 == x) return x;
        int rem = x%10;
        return rem* (int) Math.pow(10,dig-1) + helper(x/10,dig-1);
    }
    static int reverseNumber1(int x){
        int dig = (int) (Math.log10(x))+1;
        return helper(x,dig);
    }
    public static void main(String[] args) {
        int ans = sumDigits(1392);
        int mul = multiplyDigits(13092);
        System.out.println(ans);
        System.out.println(mul);
        reverseNumber(13092);

        System.out.println(reverseNumber1(23984));
    }
}
