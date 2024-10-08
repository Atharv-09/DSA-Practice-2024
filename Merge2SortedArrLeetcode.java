//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// MERGE IN TC : O(N+M)
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]

import java.util.*;
public class Merge2SortedArrLeetcode {
    


    // Brute force :
    // add the second array into first array and then sort the first array
    // TC : O(n+m) log(n+m);
    public static void mergeTwoSortedArrayLeetcode1(int[] arr1,int[] arr2,int m,int n){

        int x = m;
        for(int i=0;i<n;i++){
            arr1[x++] = arr2[i];
        }
        Arrays.sort(arr1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
    }

    // Optimal -1 
    //  Two Pointer
    // We will take 2 pointer which point to the end of array elements and third pointer point to the first array end index

    // TC : O(m+n) SC : O(1)
    public static void mergeTwoSortedArrayLeetcode2(int[] arr1,int[] arr2,int m,int n){
        
        int x = m-1;
        int y = n-1;
        int end_ind = arr1.length-1;

        while(y >= 0){

            if(x>=0 && arr1[x] > arr2[y]){
                arr1[end_ind--] = arr1[x--];
            }else{
                arr1[end_ind--] = arr2[y--];
            }
        }
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
    }
    // Refer for above same solution with slitly diff approach- https://leetcode.com/problems/merge-sorted-array/solutions/4722196/simple-beginner-friendly-dry-run-two-pointer-loops-time-o-m-n-space-o-1-gits/

    public static void main(String[] args) {
        
        int[] arr1 = new int[]{1,4,8,9,0,0,0,0,0,0};
        int[] arr2 = new int[]{0,1,1,4,6,9};
        
        mergeTwoSortedArrayLeetcode2(arr1,arr2,4,arr2.length);
    }

}
