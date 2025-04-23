package Recursion;

public class Check {

    static void print(int num,int n){
        if(num > n) return;
        System.out.print(num);
        print(num+1,n);
    }
    public static void main(String[] args) {

        // print first 5 numbers

        print(1,5);
    }
}
