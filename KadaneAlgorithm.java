
//Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.
// arr = [-2,1,-3,4,-1,2,1,-5,4]  -> 6 ( [4,-1,2,1] has the largest sum = 6. )

public class KadaneAlgorithm {
    
    public static void maxSubArraySum(int[] arr,int n){

        // 1. Using 3 for loops O(N^3)
        // 2. Using 2 for looop
        //Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

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
