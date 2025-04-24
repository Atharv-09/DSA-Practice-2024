package Recursion;

public class CheckArraySortedOrNot {

    boolean helper(int[] arr,int i,int n){
        if(i == n-1) return true;
        return arr[i]<arr[i+1] && helper(arr,i+1,n);
    }
    void check(int[] arr){

        boolean s = helper(arr,0,arr.length);
        System.out.println(s);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,12,9,10,14};
        new CheckArraySortedOrNot().check(arr);
    }
}
