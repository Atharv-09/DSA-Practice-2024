package Recursion.A2ZSheet.subsequences;
/*Input: N = 3, arr[] = {5,2,1}

Output: 0,1,2,3,5,6,7,8

Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8*/

public class SubsetsSum1 {

    static void helper(int[] arr,int n,int sum,int index){

        if(index == n){
            System.out.println(sum);
            return;
        }

        helper(arr,n,sum+arr[index],index+1);
        helper(arr,n,sum,index+1);
    }
    public static void main(String[] args) {

        int[] arr = new int[]{5,2,1};
        helper(arr,arr.length,0,0);
    }
}
/*Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it.
       So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).
 Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.*/