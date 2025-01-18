package Strings;
//Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).


public class Pow_Implementation {

    // Brute force
    public static double myPow1(double x, int n) {
        
        double ans = 1d;
        boolean neg=false;
        if(n<0){
            neg = true;
            n = -n;
        }
        for(int i=0;i<n;i++){
            ans = ans * x;
        }
        if(neg){
            return (double)1.0 / (double) ans;
        }
        return (double) ans;
    }
    // Binary exponentation
    // TC : O(logn)
    public static double myPow2(double x, int n) {

        double ans = 1.0;
        long nn = n;
        if(nn < 0) nn = -1*nn;
        while (nn>0) {
            
            if(nn%2 == 0){
                // x^4 = x*x ^ 2
                x = x*x;
                n = n/2;
            }else{
                // x^5 = x * (x*x) ^ 2
                ans = ans * x;
                nn = nn-1; 
                // or we can add 
                // x = x * (x*x); nn = nn/2;
            }
            
        }
        if(n<0) ans = (double)1.0 / (double)(ans);
        return ans;
    }
    // RECURSICE
    public double myPow(double x, int n) {
        
        if(n==0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0){
            n = n*-1; // make n posittive
            x = 1/x; // make x divide by 1
        }

        if(n % 2 == 0){
            return myPow(x*x,n/2);
        }else{
            return x*myPow(x*x,n/2);
        }
    }
    public static void main(String[] args) {
        
        System.out.println(myPow1(4,-4));
    }
}
