package Recursion.A2ZSheet.Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    static void helper(int[] arr, int target, int ind, List<List<Integer>> ans, List<Integer> ds){

        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= target){ // pick the element only if that element is not greater then target
            ds.add(arr[ind]);
            // pick the same element
            helper(arr,target-arr[ind],ind,ans,ds);
            ds.remove(ds.size()-1); // remove that element
        }
        // don't pick the same element pick another element
        helper(arr,target,ind+1,ans,ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,0,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,2};
        System.out.println(combinationSum(arr,5));
    }
}
