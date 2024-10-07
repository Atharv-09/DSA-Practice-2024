import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountSubArraywithGivenSumK {


    // TIME : O(N) SPCE : O(N)
    // USING HASHSET

    public static void countSubArrays(int[] arr,int n,int k){

        HashSet<Integer> set = new HashSet<>();

        int currSum = 0,count=0;
        for(int i=0;i<n;i++){
            currSum += arr[i];
            if(currSum == k ) count++;
            else if(currSum > k){
                int check = currSum-k;
                if(set.contains(check)) count++;
            }

            set.add(currSum);
        }

        System.out.println(count);
    }

    // USING HASHMAP
    public static void countSubArrays1(int[] arr,int n,int k){

            Map<Integer,Integer> mpp = new HashMap<>();
            int preSum = 0, cnt = 0;

            mpp.put(0, 1); // Setting 0 in the map.
            for (int i = 0; i < n; i++) {
                // add current element to prefix Sum:
                preSum += arr[i];

                // Calculate x-k:
                int remove = preSum - k;

                // Add the number of subarrays to be removed:
                if(mpp.containsKey(remove))
                    cnt += mpp.getOrDefault(remove, 0);

                // Update the count of prefix sum
                // in the map.
                mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
            }
            System.out.println(cnt);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,5,1,2,3,5};

        countSubArrays(arr,arr.length,8);
    }
}
