import java.util.HashMap;

public class LongestSubarrayWith0Sum {
    
    static void findLongesSubArray(int[] arr,int n){

        // BBrute force : check each subarray sum 
        // TC : O(N^3) 

        // Better : Instead of going for each indexs 3 times we know the prefix-sum at current index will take sum till index
        // TC : O(N^2)

        // Optimal

        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int maxLenSubArraySum0 = 0;
        for(int i=0;i<n;i++){

            preSum += arr[i];

            if(preSum == 0){
                maxLenSubArraySum0 = i+1;
            }else{
                if(map.containsKey(preSum)){
                    int index = map.get(preSum);
                    maxLenSubArraySum0 = Math.max(maxLenSubArraySum0,i-index);
                }
            }
            map.putIfAbsent(preSum, i);
        }
        System.out.println(maxLenSubArraySum0);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{6, -2, 2, -8, 1, 7, 4, -10};
        findLongesSubArray(arr,arr.length);
    }
}
