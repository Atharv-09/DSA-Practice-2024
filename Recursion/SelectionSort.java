package Recursion;

import java.util.Arrays;

public class SelectionSort {

    void helper(int[] arr,int r,int c,int maxInd){

        if(r == 0) return;
        // 4 3 8 1
        // 4 3 8
        // 4 3
        // 4 like his we took r and c
        if(c<r){ // for the 2d arrays we can say
            if(arr[c] > arr[maxInd]) {
                helper(arr, r, c + 1, c); // make this curr index element as maxInd
            }else{
                helper(arr,r,c+1,maxInd); // if not then make maxInd same
            }
        }else{
            int temp = arr[r-1];
            arr[r-1] = arr[maxInd];
            arr[maxInd] = temp;
            helper(arr,r-1,0,0);
        }
    }
    void sort(int[] arr){

        helper(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {

        int[] arr = new int[]{5,4,1,9,2};
        new SelectionSort().sort(arr);
    }
}
