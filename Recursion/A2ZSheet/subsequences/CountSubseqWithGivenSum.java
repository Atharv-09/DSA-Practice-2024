package Recursion.A2ZSheet.subsequences;

public class CountSubseqWithGivenSum {

    static int helper(int[] arr, int n, int index, int sum, int k){

        if(index == n){
            if(sum == k) {
                return 1;
            }
            return 0;
        }
        sum =sum+arr[index];
        int l = helper(arr,n,index+1,sum,k);

        sum = sum-arr[index];
        int r = helper(arr,n,index+1,sum,k);

        return l+r;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{3,2,1,4,2,3,7};
        int sum = 5;
        int ans = helper(arr,arr.length,0,0,sum);

        System.out.println(ans);
    }
}
