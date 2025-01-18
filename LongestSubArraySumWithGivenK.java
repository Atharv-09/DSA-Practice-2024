import java.util.HashMap;

public class LongestSubArraySumWithGivenK {
    
    // Brute 
    // 1. take 3 loops and check each subarray

    // using 2 for loops 
    //better
    // use hashmap and store the totalSum ttill index and the index such that if we wamt to remove from 
    // TC : O(N) SC : O(N)
    
    public static int lenOfLongestSubarr(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int totalSum = 0;
        int maxLen = Integer.MIN_VALUE;
      
        
        for(int i=0;i<arr.length;i++){
        
            totalSum += arr[i];
            
            if(totalSum == k)
                maxLen = Math.max(maxLen,i+1);
                
            int preExists = totalSum-k;
            
            if(map.containsKey(preExists))
                maxLen = Math.max(maxLen,i-map.get(preExists));
            
            if(!map.containsKey(totalSum))
                map.put(totalSum,i);
            
        }
        return maxLen;
    }    

    // if we have only +ve in the array we can further optimze the space complexity
    // YUsing 2 poitners approach
    // TC : O(N) 
    // SC : O(1)

    public static int lenOfLongestSubarr1(int arr[],int k){

        int i = 0;
        int j = 0;

        int totalSum = 0;
        int maxLen = 0;

        while(j<arr.length){

            totalSum += arr[j];
            if(totalSum == k)
                maxLen = Math.max(maxLen,j-i+1);
            else if(totalSum > k)
                totalSum -= arr[i++];
        
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {8,2,3,3,1,2,2,6};
        int ans = lenOfLongestSubarr1(arr,5);
    
        System.out.println(ans);
    }
}
