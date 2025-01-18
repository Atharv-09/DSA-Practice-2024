/*Input: arr = [4,0,-1,3,5,3,6,8], k = 3

Output: [4,3,5,5,6,8]

Explanation: 

Window position                   Max
------------------------         -----
[4  0  -1] 3  5  3  6  8           4
 4 [0  -1  3] 5  3  6  8           3
 4  0 [-1  3  5] 3  6  8           5
 4  0  -1 [3  5  3] 6  8           5
 4  0  -1  3 [5  3  6] 8           6
 4  0  -1  3  5 [3  6  8]          8

For each window of size k=3, we find the maximum element in the window and add it to our output array.*/
package Queue;

import java.util.ArrayList;

public class SlidingWindowMax {
    
    // TC : O(N^2) one loop for traversing and another to find Max
    // Sc : O(K)
    
    static void getMax(int[] arr,int l,int r,ArrayList<Integer> list){

        int maxi = Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            maxi = Math.max(maxi,arr[i]);
        }
        list.add(maxi);
    }
    static ArrayList<Integer> findMax(int[] arr,int n,int k){

        int left = 0,right = 0;
        while(right<k-1) right++;

        ArrayList<Integer> maxEle = new ArrayList<>();
        while(right<n){
            getMax(arr,left,right,maxEle);
            left++;
            right++;
        }
        return maxEle;
    }
    public static void print(ArrayList<Integer> ans){
        ans.forEach(System.out::println);
    }
    public static void main(String[] args) {
        
        int[] arr = {4,0,-1,3,5,3,6,8};
        ArrayList<Integer> ans = findMax(arr,arr.length,3);

        print(ans);
    }
}
