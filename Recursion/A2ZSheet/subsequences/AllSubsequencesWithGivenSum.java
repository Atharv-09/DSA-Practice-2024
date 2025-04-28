package Recursion.A2ZSheet.subsequences;

import java.util.ArrayList;
import java.util.List;
/*Input: arr[] = [1, 2, 3], k = 3
Output: [ [1, 2], [3] ]
Explanation: All the subsequences of the given array are:
[ [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], [] ]
Out of which only two subsequences have sum of their elements equal to 3.


Input: arr[] = [1, 2, 3], k = 7
Output: []
Explanation: Sum of all the elements of the array is 6, which is smaller than the required sum, thus they are no subsequences with sum of its elements equal to 7.*/
public class AllSubsequencesWithGivenSum {

    static void find(int[] arr,int n,int index,int sum,int k,List<Integer> list){

        if(index == n){
            if(sum == k){
                System.out.println(list);
            }
            return;
        }
        // pick element
        list.add(arr[index]);
        sum += arr[index]; // add to sum
        find(arr,n,index+1,sum,k,list);

        // remove element
        list.remove(list.size()-1);
        sum -= arr[index]; // remove from sum
        find(arr,n,index+1,sum,k,list);
    }
    public static void main(String[] args) {

        int[] arr=  new int[]{1,2,3,1};
        find(arr,arr.length,0,0,4, new ArrayList<>());

    }
}

/* or we can do*/
// we will not take and not add any value to sum means we are going not take then take
/* find(arr,n,index+1,sum,k,list)
 *  Not take
 *  list.add(arr[index]);
 *  sum+= arr[index];
 *  find(arr,n,index+1,sum,k,list);
 *
 *  // remove that
 *  list.remove(list.size()-1);
 * */