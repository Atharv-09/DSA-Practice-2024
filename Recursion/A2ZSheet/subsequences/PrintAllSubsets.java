package Recursion.A2ZSheet.subsequences;
/*78. Subsets
Solved
Medium
Topics
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]*/

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
    /*TC : O(2^n) [ n is number of elements in the input array.
     We have two choices for each number. For examples, length of input array is 3(= n), output should be 2 * 2 * 2 = 8 subsets]
    * SC : O(2^n) */
    static void helper(int[] nums,int i,int n,List<List<Integer>> ans,List<Integer> list){
        if(i == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]); // include current element in ans
        helper(nums,i+1,n,ans,list);
        list.remove(list.size()-1); // remove current element from answer
        helper(nums,i+1,n,ans,list);

    }
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,nums.length,ans,new ArrayList<>());

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        System.out.println(subsets(arr));
    }
}
