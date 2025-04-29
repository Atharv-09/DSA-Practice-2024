package Recursion.A2ZSheet.Combination;

import java.util.*;
/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]*/
public class CombinationSum2 {

    // BRUTE FORCE
    static void helper2(int[] arr, int target, int ind, Set<List<Integer>> ans, List<Integer> ds){

        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= target){ // pick the element only if that element is not greater then target
            ds.add(arr[ind]);
            // pick the same element
            helper2(arr,target-arr[ind],ind+1,ans,ds);
            ds.remove(ds.size()-1); // remove that element
        }
        // don't pick the same element pick another element
        helper2(arr,target,ind+1,ans,ds);
    }

    // better
    static void helper3(int[] arr, int target, int ind, List<List<Integer>> ans, List<Integer> ds){

        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<arr.length;i++){

            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            helper3(arr,target-arr[i],i+1,ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

//        Set<List<Integer>> ans = new HashSet<>();
//        helper2(candidates,target,0,ans,new ArrayList<>());

        List<List<Integer>> ans2 = new ArrayList<>();
        Arrays.sort(candidates);
        helper3(candidates,target,0,ans2,new ArrayList<>());

        return ans2;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,3,1,4};
        System.out.println(combinationSum2(arr,4));
    }
}
