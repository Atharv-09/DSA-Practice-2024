public class ArmStrongNumber {
    public static void main(String[] args) {
        

        int num =153;

        int countDigits = 0;
        int n1 = num;
        while(n1>0){
            countDigits++;
            n1/=10;
        }
        
        n1 = num;
        int totalOfDigits = 0;
        while(n1>0){
            int dig = n1 % 10;
            totalOfDigits += Math.pow(dig, countDigits);

            n1/=10;
        }

        String s = totalOfDigits == num ? ("YES") : ("NO");
        System.out.println(s);
        
    }    
}
