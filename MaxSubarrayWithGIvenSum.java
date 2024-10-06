import java.util.*;
public class MaxSubarrayWithGIvenSum {
    
    // FOR ONLY +VE ELEMENT IN ARRAY
    // using 2 pointers

    void maxSubArray1(int[] arr,int n,int k){

        // 10 3 2 1 9 6 K= 15

        int left = 0,right=0;
        int totalSum = arr[0];
        int maxLen = 0;
        while(right < n){

            while(left <= right && totalSum>k){
                totalSum = totalSum - arr[left];
                left++;
            }
            if(totalSum == k){
                maxLen = Math.max(maxLen,right+1);
            }
            right++;
            if(right<n) totalSum += arr[right];
        }
        System.out.println(maxLen);
    }

    // FOR 0,-VE, +VE ELEMENT IN ARRAY
    
    // USING HASHMAP 
    // TIME : O(N) SPACE : O(N)
    void maxSubArray(int[] arr,int n,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        int totalSum = 0;
        int maxLength = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){

            totalSum += arr[i];
            if(totalSum == k){
                maxLength = Math.max(maxLength,i+1);
            }

            int rem = totalSum-k;

            if(map.containsKey(rem)){
                maxLength = Math.max(maxLength,i-map.get(rem));
            }
            if(!map.containsKey(totalSum)){
                map.put(totalSum,i);
            }

        }

        System.out.println(maxLength);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,0,0,3};
        new MaxSubarrayWithGIvenSum().maxSubArray1(arr, arr.length, 2);
    }
}
