public class 03_GCD_LCM {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long[] ans = new Long[2];
        
        for(long i=Math.min(A,B);i>0;i--){
            // going from lower value to 1 [As if we traverse from 1 to Lower value it will much time then below]
            if(A%i ==0 && B%i==0){
                ans[1] = i;
                break;
            }
        }
        
        // using Euclidean Algo
        // The Euclidean Algorithm is a method for finding the greatest common divisor of two numbers. It operates on the principle that the GCD of two numbers remains the same even if the smaller number is subtracted from the larger number.
        
        // ans[1] = gcd(A,B);
        ans[0] = A*B / ans[1];
        
        return ans;
    }
    
  static long gcd(long n1,long n2){
    
    while(n1>0 && n2>0){
        if(n1 > n2){
            n1 = n1%n2;
        }else{
            n2 = n2%n1;
        }
    }
    
    return n1 == 0 ? n2 : n1;
  }


}
