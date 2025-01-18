/*You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.*/

/*Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 =  */


public class SumOfSubArrayRanges {
    
    // Brute force
    // TC : O(n^2)
    // SC : O(1)
    static void findSum_brute(int[] arr,int n){

        int sum = 0;
        for(int i=0;i<n;i++){

            int min=arr[i],max=arr[i];
            for(int j=i;j<n;j++){
                min = Math.min(arr[j],min);
                max = Math.max(arr[j],max);
                sum += (max-min);
            }
        }
        System.out.println(sum);
    }

// optimized

// TC : O(5N) + O(5N) = O(10N) = O(N)
// SC : O(5N) + O(5N) = O(10N)

// arr [1 4 3 2]
// 1 , 1 4, 1 4 3 , 1 4 3 2 = (1-1) + (4-1) + (4-1) + (4-1) = (sum of the maximum of subarrays) - (sum of the minimums of subarrays)
// 4 , 4 3 , 4 3 2 = (4-4) + (4-3) + (4-2) 
// 3 , 3 2 = (3-3) + (3-2)
// 2 = (2-2)

// Sumation of all subarray largest - sumation of all subarray smallest
// sum of subarray maximums - sum of subarray minimums (prolblem)

// we can say the sum of subarray rnaes if the sum of max of subarrays minus

    static void findSum(int[] arr,int n){

        int sumOfMaximumElementOfSubarrays = SumOfSuArraysMaximum.findSumOfMaxofSubarrays(arr,n);
        int sumOfMinimumElementOfSubarrays = SumOFSubArraysMinimums.findSumOfMinofSubarrays(arr, n);

        System.out.println(sumOfMaximumElementOfSubarrays-sumOfMinimumElementOfSubarrays);
    }
    // optimized
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,4,3,2};
        findSum(arr,arr.length);
    }
}
