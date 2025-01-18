public class ValidPalindrome {
        public boolean isPalindrome(String s) {
            
           int p1 = 0;
           int p2 = s.length()-1;
    
           while(p1<p2){
                char c1 = s.charAt(p1);
                char c2 = s.charAt(p2);
    
                if(!Character.isLetterOrDigit(c1)){
                    p1++;
                }else if(!Character.isLetterOrDigit(c2)){
                    p2--;
                }else{
    
                    if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                        return false;
                    }
                    p1++;p2--;
                }
           }
           return true;
        }
        

        // USING RECURSION
        static boolean palindrome(int i, String s){
        
            // Base Condition
            // If i exceeds half of the string, means all the elements 
            // are compared, we return true.
            if(i>=s.length()/2) return true;
            
            // If start is not equal to end, not palindrome.
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
            
            // If both characters are same, increment i and check start+1 and end-1.
            return palindrome(i+1,s);
            

    }

    public static void main(String[] args) {
        System.out.println(palindrome(0, "Atharva"));
    }
}
