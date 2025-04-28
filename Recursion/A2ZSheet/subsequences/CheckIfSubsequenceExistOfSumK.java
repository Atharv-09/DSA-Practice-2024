package Recursion.A2ZSheet.subsequences;

import java.util.ArrayList;
import java.util.List;
/*Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals the given target sum(k).


Example:

Input:  arr = [10,1,2,7,6,1,5], k = 8.
Output:  Yes
Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8

Input:  arr = [2,3,5,7,9], k = 100.
Output:  No
Explanation:  No subsequence can sum upto 100*/
public class CheckIfSubsequenceExistOfSumK {
    static boolean helper(int n, int[] arr, int k, List<Integer> list, int index, int sum){

        if(sum ==k) return true;
        if(sum<k && index==n) return false;
        if(sum>k) return false;

        list.add(arr[index]);
        sum+=arr[index];
        if(helper(n,arr,k,list,index+1,sum) == true)
            return true;

        list.remove(list.size()-1);
        sum-=arr[index];
        if(helper(n,arr,k,list,index+1,sum) == true)
            return true;
        return false;
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        return helper(N,arr,K,new ArrayList(),0,0);
    }

    public static void main(String[] args) {
        System.out.println(checkSubsequenceSum(4,new int[]{1,2,3,1},8));
    }
}
