//Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
/*n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

*/

import java.util.*;
public class Merge2SortedArr {

    // brute force by taking extra space
    // TIME : O(min(n,m)) 
    static void mergeTwoSortedArray(int[] arr1,int[] arr2,int n,int m){

        int[] temp = new int[n+m];

        int left = 0;
        int right = 0;
        int x = 0;

        while(left<n && right<m){

            if(arr1[left] <= arr2[right]){
                temp[x++] = arr1[left];
                left++;
            }else{
                temp[x++] = arr2[right];
                right++;
            }
        }

        while(left<n){
            temp[x++] = arr1[left++];
        }
        
        while(right<m){
            temp[x++] = arr2[right++];
        }

        for(int i=0;i<(n+m);i++){

            if(i<n)  arr1[i] = temp[i];
            else arr2[i-n] = temp[i];
        }
    }

    // Optimal 1-without using extra space
    // TC : O(min(n,m))+O(nlogn)+O(mlogm)
    // SC : O(1)


    static void mergeTwoSortedArray1(int[] arr1,int[] arr2,int n,int m){

        int left = n-1;
        int right = 0;

        while(left >= 0 && right<m ){
            // if the left element i.e the reater element of arr1  is greater then smaller element of arr2 swap
            if(arr1[left]>=arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        print(arr1, arr2, n, m);
    }

    // Optimal 2-without using extra space
    // Using Gap method
    // TIME : O((n+m)*log(n+m))
    // The gap is ranging from n+m to 1 and every time the gap gets divided by 2. So, the time complexity of the outer loop will be O(log(n+m)). Now, for each value of the gap, the inner loop can at most run for (n+m) times. So, the time complexity of the inner loop will be O(n+m)
    static void swapIfGreater(int[] arr1,int[] arr2,int ind1,int ind2){
        if(arr1[ind1] > arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    static void mergeTwoSortedArray2(int[] arr1,int[] arr2,int n,int m){
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
        print(arr1, arr2, n, m);

    }

    public static void print(int[] arr1,int[] arr2,int n,int m){
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<m;i++){
            System.out.print(arr2[i]+" ");
        }
    }
    public static void main(String[] args) {
        
        int[] arr1 = new int[]{1,4,8,9};
        int[] arr2 = new int[]{0,1,1,4,6,9};
        
        mergeTwoSortedArray2(arr1,arr2,arr1.length,arr2.length);
        // print(arr1,arr2,arr1.length,arr2.length);
    }
}
