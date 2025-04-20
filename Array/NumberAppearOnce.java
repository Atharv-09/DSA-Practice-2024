//Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

import java.util.*;
public class NumberAppearOnce {
    
    // O(N^2)
    // Linear Search
    // we can check every number and which is not having duplicate break loop and print

    // O(Nlog^N)
    // Sort the array and check arr[i] == arr[i+1] 

    static int findNumber1(int[] nums,int n){

            Arrays.sort(nums);

            for(int i=0;i<nums.length-1;i+=2){
                if(nums[i] != nums[i+1]) return nums[i];
            }
            return nums[nums.length-1];
            
    }
    // O(N) and space : O(N)
    // Take HashMap and put (number,occurence) and check whose occurence is <2 print that key
    // 1. hashing using hash array by taking maximum elemen from array and create hash array of size of hat maxEleme+1 and put the element at that index as ++
    // 2. using HashMap
     
    // Take HashSet and put the number into that, if the number is already thier in set then remove that number from set as the last remaingin nuber will be our ans

    static int findNumber2(int[] arr,int n){

   
            HashMap<Integer, Integer> mpp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int value = mpp.getOrDefault(arr[i], 0);
                mpp.put(arr[i], value + 1);
            }

            //Find the single element and return the answer:
            for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
                if (it.getValue() == 1) {
                    return it.getKey();
                }
            }
            //if the array contains a single element.
            return -1;
    }


    // Using XOR as we know the same element xor is 0 so we will get the non duplicate element from thier
    // Time : O(N) space : O(1)
    static void findNumber(int[] arr,int n){

        int xor  = 0;
        for(int i=0;i<n;i++){
            xor = xor ^ arr[i];
        }

        System.out.println(xor);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{4,1,1,4,9,1,2,1,2};
        findNumber(arr,arr.length);
    }
}
