//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

/*Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
i=0
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOFSubArraysMinimums {
    
    // brute force: 
    // generate all subarray and get the min of them 
    // TC : O(N^2)
    // SC : O(1)
    static int findSumOfMinofSubarrays_brute(int[] arr,int n){

        int total = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<n;i++){

            int min = arr[i];
            for(int j=i;j<n;j++){
                min = Math.min(min,arr[j]);
                total = (total+min)%mod;
            }
        }
        return total;
    }

    // Optimal
    // TC : O(2N + 2N + N)  = O(n)
    // SC : O(3n)
    static int[] findNextSmallerElement(int[] arr,int n){

        Stack<Integer> st = new Stack<>(); // we wil store the indexes not tehe element
        int[] right = new int[n];

        for(int i=n-1;i>=0;i--){

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();

            st.push(i);
        }
        return right;
    }
     
    static int[] findPrevSmallerElement(int[] arr,int n){
        Stack<Integer> st = new Stack<>(); // we wil store the indexes not tehe element
        int[] left = new int[n];

        for(int i=0;i<n;i++){

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();

            st.push(i);
        }
        return left;
    }
    static int findSumOfMinofSubarrays(int[] arr,int n){

        int total = 0;
        int mod = (int) (1e9 +7);
        int[] nextMinElementIndexes = findNextSmallerElement(arr,n);
        int[] prevMinElementIndexes = findPrevSmallerElement(arr,n);
    
        int left=0,right=0;
        for(int i=0;i<n;i++){
            
            left = i-prevMinElementIndexes[i];
            right = nextMinElementIndexes[i]-i;

            total += (long) (left) * (right) % mod * arr[i] % mod;
            total %= mod;
            // total = (long)(total + (right*left*arr[i])%mod) % mod;
        }
        return total;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,1,3,4};
        System.out.println(findSumOfMinofSubarrays(arr,arr.length));
    }
}
