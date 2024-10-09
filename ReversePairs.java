import java.util.*;
//Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

// N = 5, array[] = {1,3,2,3,1)  op =  2  {(3, 1) and (3, 1)}
// {3,2,1,4} op = 1 {{3,1}};

public class ReversePairs {
    
    //BRUTE 
    // O(N^2) take each pair and check
    public static int reversePairsCountBrute(int[] a, int n) {

        // Count the number of pairs:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > 2 * a[j])
                    cnt++;
            }
        }
        return cnt;
    }


    // OPTIMAL APPROACH (Using Count Inversion approach , Merge sort)
    //TC :  O(2n*logn)
    public static void merge(int[] arr,int low,int mid,int high){

        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>(); 
    
        //storing elements in the temporary array in a sorted manner//
        while(left<= mid && right<=high){

            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
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
    }

    public static int countPairs(int[] arr,int low,int mid,int high){

        int count= 0;
        int right = mid+1;
        for(int i=low;i<=mid;i++){
            // travers to right in arr2 till arr1 element is greater then arr2 element
            while(right <= high && (0.5 *arr[i]) > arr[right]) right++;
            count = count + (right-(mid+1)); // we will be adding number of element to left side or right array such that arr1[i] > 2*arr2[right]
        }

        return count;
    }
    public static int mergeSort(int[] arr,int low,int high){
        int count = 0;

        if(low < high){
            int mid = (low+high)/2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid+1, high);
            count += countPairs(arr,low,mid,high);
            merge(arr,low,mid,high);
        }
        return count;
    }
    public static int reversePairsCount(int[] arr,int n){

        return mergeSort(arr,0,n-1);
    }
    

    public static void main(String[] args) {
        
        int[] arr = new int[]{3,2,7,3,1,8,1}; // pairs = (3,1)(3,1)(7,1)(7,3)(7,1)(3,1)(3,1)(8,1)
        System.out.println(reversePairsCount(arr,arr.length));
    }


}
