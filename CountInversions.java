/*Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

*/

// N = 5, array[] = {1,2,3,4,5} op = 0 as not arr[i]>arr[j];
//: N = 5, array[] = {5,4,3,2,1} op = 10 as max element arr[i] > arr[j]
//: N = 5, array[] = {5,3,2,1,4} op = 7 as {(5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1)} makes the pair
 // TUF : https://takeuforward.org/data-structure/count-inversions-in-an-array/


import java.util.*;
public class CountInversions {


    // BRUTE FORCE (O(N^2))
    // By taking each element and comparing with rest right side element
    public static int countInversionBrute(int[] a,int n){

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) cnt++;
            }
        }
        return cnt;
    }
    // Optimal Approach [Merge sort]
    // Time : O(nlogn) Space : O(n)

    // As we know in merge sort we will first divide the left and right subarray and conquer by checking which wlemen is small is on left side
    // such that while merging check if arr1 element is greater then arr2 element then all element right to arr1 is greatter then arr2 element [as array is sorted]
    // so we will add that into count and if arr1 elemtn is not greater then arr2 we will go next in arr1 
    public static int merge(int[] arr,int low,int mid,int high){

        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>(); 
        int count = 0;


        //storing elements in the temporary array in a sorted manner//
        while(left<= mid && right<=high){

            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else { // (arr[left] > arr[right])
                temp.add(arr[right]);
                count += (mid-left+1); // we will add the count all the element from array 1 {as the arr1 is sorted if one of the element is greater then arr2 element
                    // then all the elements right to that arr1 element is greater then that arr2 element }
                right++;
            }
        }

        // if the element left in LEFT half of array
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        // if the element left in RIGHT half of array
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        // transfer all element from tempm to arrat

        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
        return count;
    }
    public static int mergeSort(int[] arr,int low,int high){
        int count = 0;

        if(low < high){
            int mid = (low+high)/2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid+1, high);

            count += merge(arr,low,mid,high);
        }
        return count;
    }
    public static int countInversion(int[] arr,int n){

        return mergeSort(arr,0,n-1);
    }
    

    public static void main(String[] args) {
        
        int[] arr = new int[]{3,2,7,3,1,8,1};
        // System.out.println(countInversion(arr,arr.length));
        System.out.println(countInversionBrute(arr,arr.length));
    }
}
