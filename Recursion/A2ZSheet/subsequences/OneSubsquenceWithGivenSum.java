package Recursion.A2ZSheet.subsequences;

import java.util.ArrayList;
import java.util.List;

// q1. return only 1 subseuence that sums equal to k
// q2. Check if there exists a subsequence with sum K
/*Input:  arr = [10,1,2,7,6,1,5], k = 8.
Output:  Yes
Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8*/

// we can use below implementation as it is decreasing the recursive call for other even we got a single it will return true/false
public class OneSubsquenceWithGivenSum {
    static boolean find(int[] arr, int n, int index, int sum, int k, List<Integer> list){

        if(index == n){
            // condition satisfied
            if(sum == k){
                System.out.println(list);
                return true;
            }
            // condition not sati
            return false;
        }
        // pick element
        list.add(arr[index]);
        sum += arr[index]; // add to sum
        if(find(arr, n, index + 1, sum, k, list)) return true;

        // remove element
        list.remove(list.size()-1);
        sum -= arr[index]; // remove from sum
        if(find(arr,n,index+1,sum,k,list)) return true;

        return false;
    }
    public static void main(String[] args) {

        int[] arr=  new int[]{1,2,3,1};
        find(arr,arr.length,0,0,4, new ArrayList<>());

    }
}
