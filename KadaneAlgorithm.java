
//Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.
// arr = [-2,1,-3,4,-1,2,1,-5,4]  -> 6 ( [4,-1,2,1] has the largest sum = 6. )

public class KadaneAlgorithm {
    
    public static void maxSubArraySum(int[] arr,int n){

        // 1. Using 3 for loops O(N^3)
        // 2. Using 2 for looop
        //Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].
        // 3. Using Dynamic Programming

        /*Take one varibale as a global maximum , say max (To keep track maximum value) dp[i] means max sum subarray ending at index i If sum till i-1 is is usefull , then take it other wise take current cell as sum till i */

        /*public int maxSubArray(int[] nums) {
                int storage []=  new int[nums.length];
                int max  =  nums[0];
                storage[0 ] =  nums[0];
                for( int i=1;i<nums.length ;i++  ){
                    storage[i] =  Math.max( storage[i-1]+nums[i] ,  nums[i]);
                    if(storage[i]>max){
                        max=  storage[i];
                    }
                }
                return max;    
     } */



        // Kadane's Algo
        // TIME : O(N)
        int currentSum = 0;
        int start = 0;
        int ansEnd = -1,ansStart=-1;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            // if we encouuunter -ve element we are doingg currenSum = 0 so tha means the new array start will be thier so take that index
            if(currentSum == 0) start = i;

            currentSum += arr[i];
         
            if(currentSum > maxSum){
                maxSum = currentSum;
                // as we get the maxElementSum by adding currELement we are considering that index as the last index and start index will be the one which we took when it is started
                ansStart = start;
                ansEnd = i;
                
            }
            if(currentSum < 0){
                currentSum = 0;
            }

        }

        System.out.println("Maxium subarray sum = " + maxSum + " Starts at : " + ansStart + " Ends at : " + ansEnd);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{-2,1,15,-3,4,-1,2,1,-5,4};

        maxSubArraySum(arr,arr.length);
    }
}


//---------------------------------------------------------------------------
// Using Divide and Conquoeror
/*Split our array into two halves
case1: maxSum subaaray occur in left half ,
case2: maxSum subarray occur in right half
case3: maxSum subaaray lies about middle of array */

public int maxSubArray(int[] nums) {
    
    return helper(nums,0,nums.length-1);
}

public int helper(int nums[],int i,int j){

        if(i==j){
            return nums[i];
        }
                        
        int mid  =  (i+j)/2;
        int sum = 0,leftMaxSUM = Integer.MIN_VALUE;
        // here we are going from mid to left and adding to sum such that we are assuming the left array having max sum
        for(int l =  mid;l>=i;l--){
            sum+=nums[l];
            if(sum>leftMaxSUM){
                leftMaxSUM =  sum;
            }                                    
        }
        
        int rightMaxSUM = Integer.MIN_VALUE;
        // here we are going from mid+1 to right and adding to sum such that we are assuming the right array having max sum
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            sum += nums[l];
            if (sum > rightMaxSUM ) {
                rightMaxSUM = sum;
            }
        }
       // here we are taking the max of left / right subarrays 
    int maxLeftRight = Math.max(helper(nums, i, mid),
                                    helper(nums, mid + 1, j ));
        // here we are checking the max from left and right OR by adding both left and right
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM );
        
        

}













