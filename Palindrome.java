public class Palindrome {
    public boolean isPalindrome(int x) {
        
        if(x<0 || (x != 0 && x%10 ==0)) return false;
        // time : O(logn)
        int num = x;
        int rev = 0;
        while(num > rev ){

            int dig = num % 10;
            
            rev = rev * 10 + dig;
            num /= 10;
        }
        return (rev == num || num == rev/10);
        // for odd num == rev/10 suppose if num = 143767341 and
         // here the rev will have 14376 andd num = 1437 that why we have tot check by /10

         
         // 2. using string we can reverse half
         String s = String.valueOf(x);
         StringBuilder sb = new StringBuilder(s).reverse();
         String s1 = sb.toString();

        if(s.equals(s1)) return true;
        else return false;

        // 2. we can do string charAt and check first and last char arfe same 
         String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i=0; i<n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) return false;
        }

        // if no flaws are found we return true
        return true;
    }
}
