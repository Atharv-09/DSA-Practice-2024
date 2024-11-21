package Bit_Manipulation;
import java.util.*;
/*Given an integer array nums of unique elements, return all possible subsets
 (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  */
public class PowerSet {
    
    // from the observation we can see that thier are 2^n subsets

    // we can see the pattern
    // If there are 2^3  = 8 subsets
    // take 4 4 | 2 2 | 1 1 etc
    // 2 1 0  index {1,2,3}
    // 0 0 0 -  []
    // 0 0 1 - [1]
    // 0 1 0 - [2]
    // 0 1 1 - [1,2] at 0th index 1 and at 1st index 2 is thier in org array
    // 1 0 0
    // 1 0 1
    // 1 1 0
    // 1 1 1 [4 ..4 .. | 2 .. 2 .. 2.. 2.. | 1 .. 1.. 1.. 1etc]
    // so if ther are 2^4 = 16 then we can take [8..8 | 4..4..4..4.. | etc]
    // THIER WILL BE N BITS FOR EACH NUMBER GIVEN
    // suppose n = 4 so it will go till 4 bits
    // Go from 0 to 2^n-1 and for each n we will check which it is set and as per add we will add that index element into ans list

    // TC : O(N x 2^n)
    // SC : O(2^n subsets) x N (for each of the subset but we are not sure about that)
    static List<List<Integer>> findSubSets(int[] nums,int n){

        List<List<Integer>> ans  =new ArrayList<>();
        
        int subsets = 1 << n;
        for(int num = 0;num<subsets;num++){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){

                if((num & (1<<i)) != 0)
                    list.add(nums[i]);
            }
            ans.add(list);
        }

        return ans;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> ans = findSubSets(arr,arr.length);
        for(List<Integer> x:ans){
            for(int v : x){
                System.out.print("[ " + v +" ]");
            }
            System.out.println();
        }
    }
}
