/*You are given two integer arrays arr and brr of length n, and an integer k. You can perform the following operations on arr any number of times:

Split arr into any number of contiguous subarrays and rearrange these subarrays in any order. This operation has a fixed cost of k.
Choose any element in arr and add or subtract a positive integer x to it. The cost of this operation is x.

Return the minimum total cost to make arr equal to brr.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: arr = [-7,9,5], brr = [7,-2,-5], k = 2

Output: 13

Explanation:

Split arr into two contiguous subarrays: [-7] and [9, 5] and rearrange them as [9, 5, -7], with a cost of 2.
Subtract 2 from element arr[0]. The array becomes [7, 5, -7]. The cost of this operation is 2.
Subtract 7 from element arr[1]. The array becomes [7, -2, -7]. The cost of this operation is 7.
Add 2 to element arr[2]. The array becomes [7, -2, -5]. The cost of this operation is 2.
The total cost to make the arrays equal is 2 + 2 + 7 + 2 = 13.©leetcode*/
package LeetCodeContestQue;

import java.util.Arrays;

public class MinCostToMakeArrSame {
    public static long minCost(int[] arr, int[] brr, long k) {
            // we will check the cost without sorting 
            long dCost = 0;
            for(int i=0;i<arr.length;i++){
                dCost += Math.abs(arr[i]-brr[i]);
            }
            
            // as ew sort we can get the min dif 
            Arrays.sort(arr);
          
            Arrays.sort(brr);
            long aCost = 0l;
            for(int i=0;i<arr.length;i++){
                aCost += Math.abs(arr[i]-brr[i]);
            }
            long total = aCost + k;
            return Math.min(total,dCost);
        }
        public static void main(String[] args) {
            System.out.println(minCost(new int[]{-1,4,3},new int[]{6,2,1},3));
        }
}
