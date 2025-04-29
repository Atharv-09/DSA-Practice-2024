package Recursion.A2ZSheet.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Subset - II | Print all the Unique Subsets

/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/
public class SubsetsSum2 {

    static void helper(int[] arr, int ind, List<Integer> list,List<List<Integer>> ans){

        ans.add(new ArrayList<>(list));

        for(int i=ind;i<arr.length;i++){
            if(ind!=i && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            helper(arr,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[]{1,2,2};
        Arrays.sort(arr);
        helper(arr,0,new ArrayList<>(),ans);

        System.out.println(ans);
    }
}
