package Recursion.A2ZSheet.Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    static void helper(int target,int sum,int k,int number,List<List<Integer>> ans, ArrayList<Integer> arr){

        if(sum == target && arr.size() == k) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i=number;i<=9;i++){
            arr.add(i);
            sum += i;
            helper(target,sum,k,i+1,ans,arr);
            sum -= i;
            arr.remove(arr.size()-1);
        }
        // Either we do like above one by taking sum variable and adding and removing
        // or else we can make target - i also and in if condition if the target is 0 and arr size is k return


    }
    static void findCombinations(int n,int k){

        List<List<Integer>> ans = new ArrayList<>();
        helper(n,0,k,1,ans,new ArrayList<>());
        System.out.println(ans);
    }

    public static void main(String[] args) {

        int n = 10;
        int k = 3;

        findCombinations(n,k);
    }
}
