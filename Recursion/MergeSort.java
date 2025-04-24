package Recursion;

import java.util.Arrays;

public class MergeSort {

    int[] merge(int[] left,int[] right){

        int x = 0,y=0;
        int n1 = left.length;
        int n2 = right.length;
        int newArr[] = new int[n1+n2];
        int k =0;
        while(x<n1 && y<n2){
            if(left[x]<right[y]){
                newArr[k++] = left[x++];
            }else{
                newArr[k++] = right[y++];
            }
        }

        while(x<n1){
            newArr[k++] = left[x++];
        }
        while(y<n2){
            newArr[k++] = right[y++];
        }
        return newArr;
    }
    int[] mergeSort(int[] arr){

        if(arr.length == 1) return arr;

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }
    public static void main(String[] args) {

        int arr[] = new int[]{5,8,9,12,3,17};

        int[] ans = new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }
}
