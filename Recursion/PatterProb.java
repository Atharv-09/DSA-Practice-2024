package Recursion;

public class PatterProb {

    static void pattern1(int n){

        if(n==0) return;
        for(int i=0;i<n;i++){
            System.out.print("* ");
        }
        System.out.println();
        pattern1(n-1);
    }
    // using recursion

    static void pattern2(int r,int c){

        if(r == 0) return;
        if(c<r){
            System.out.print("* ");
            pattern2(r,c+1);
        }else{
            System.out.println();
            pattern2(r-1,0);
        }
    }
    public static void main(String[] args) {

        pattern1(4);
        pattern2(4,0);
    }
}
