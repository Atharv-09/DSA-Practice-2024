package Recursion;

import java.util.Arrays;

public class BubbleSort {

    static void swap(int[] arr, int r, int c){
        int temp = arr[r];
        arr[r] = arr[c];
        arr[c] = temp;
    }
    static void bubbleSort(int[] arr,int r,int c){
    // 4 0
        if(r == 0) return;
        if(c<r){
            if(arr[c]>arr[c+1])
                swap(arr,c,c+1);
            bubbleSort(arr,r,c+1);
        }else{
            bubbleSort(arr,r-1,0);
        }
    }
    public static void main(String[] args) {

        int[] arr = new int[]{5,2,9,1,19,12,20,2,5,2};
        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
}
