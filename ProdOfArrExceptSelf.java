/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]*/


// REFER FOR SOLUION : https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview-by-1fpyp/

import java.util.Arrays;

public class ProdOfArrExceptSelf {
    
    // Brute (we will multiply all element expcet the same element)
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        
        return ans;
    }

    // Better
    // TC : O(3N)
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int n= nums.length;
        for(int i=0;i<n;i++)
            if(nums[i] == 0) countZero++;
        
        int[] ans = new int[n];
        if(countZero >= 2) return ans;

        int mul = 1,zeroI = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zeroI = i;
                continue;
            }
            mul *= nums[i];
        }
        if(countZero == 1){
            ans[zeroI] = mul;
            return ans;
        }
        for(int i=0;i<n;i++){
            ans[i] = (int) mul/nums[i];
        }
        return ans;


    }

    // Best 
    // store pre and suf and for each index multiply the pre and suf for that index
    // TC : O(N) SC : O(2N)
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;
        
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    // Optimal
    // instead of taking the extra sspace we can go from left to right and add the pref mul first and 
    // again go from right to left for the suff multiply
    public int[] productExceptSelf3(int[] nums) {

        int n = nums.length; 
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        int val = 1;

        for(int i=0;i<n;i++){
            ans[i] = ans[i] * val;
            val = val * nums[i];    
        }
        val = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i] * val;
            val = val * nums[i];   
        }
        return ans;


    }
}
