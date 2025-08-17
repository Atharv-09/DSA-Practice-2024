package Recursion.A2ZSheet.subsequences;

public class Leetcode1498 {
    int helper(int[] arr,int n,int index,int sum,int max,int min,int target){

        if(index == n){
            if((min+max) <= target) return 1;
            else return 0;
        }

        // if((min+max) > target) return 0;

        min = Math.min(min,arr[index]);
        max = Math.max(max,arr[index]);

        // sum += (min+max);
        int left = helper(arr,n,index+1,sum,min,max,target);

        int right = helper(arr,n,index+1,sum,min,max,target);
        return left+right;
    }
    public int numSubseq(int[] nums, int target) {

        return helper(nums,nums.length,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,target);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int ans = new Leetcode1498().numSubseq(arr,4);

        System.out.println(ans);
    }
}
