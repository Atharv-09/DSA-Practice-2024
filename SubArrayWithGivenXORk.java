// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

//  A = [4, 2, 2, 6, 4] , k = 6
// result = 4;  The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
//  A = [5, 6, 7, 8, 9], k = 5
// result =  The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

import java.util.*;

public class SubArrayWithGivenXORk {

    // Brute force : O(N^3)
    // we will generate all the possible subarrays and check if thier xor is equal to given k
    static void findSubArrays(int[] arr,int n,int target){

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int xor = 0;
                for(int k=i;k<=j;k++){
                    xor = xor ^ arr[k];
                }
                if(xor == target){ 
                    System.out.println("Found at i : " + i + " j : " + j);    
                count++;}
            }
        }

        System.out.println(count);
    }

    // Better Approach : as we know the current index xor will be the xor itll curr index so why to take third loop
        /*Assume previous subarray = arr[i……j-1]
        current subarray = arr[i…..j]
        XOR of arr[i….j] = (XOR of arr[i….j-1]) ^ arr[j] */

    // TC : O(N^2) SP : O(1)

    static void findSubArrays1(int[] arr,int n,int target){

        int count = 0;
        for(int i=0;i<n;i++){
            int xor = 0;
            for(int j=i;j<n;j++){                
                xor = xor ^ arr[j];
                
                if(xor == target){ 
                    System.out.println("Found at i : " + i + " j : " + j);    
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // Optimal 

    // TC : O(N) SC : O(N)
    /*Observation: Assume, the prefix XOR of a subarray ending at index i is xr. In that subarray, we will search for another subarray ending at index i, whose XOR is equal to k. Here, we need to observe that if there exists another subarray ending at index i, with XOR k, then the prefix XOR of the rest of the subarray will be xr^k. The below image will clarify the concept:
*/
    
    static void findSubArrays2(int[] arr,int n,int target){

        Map<Integer,Integer> map = new HashMap<>();

        int xor = 0;
        map.put(0,1);
        int count = 0;
        for(int i=0;i<n;i++){

            xor = xor ^ arr[i];

            int x = xor  ^ target;
            if(map.containsKey(x)){
                count += map.get(x);
            }

            if(map.containsKey(xor)){
                map.put(xor,map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{4,2,2,6,4};

        findSubArrays2(arr,arr.length,6);
    }
}
