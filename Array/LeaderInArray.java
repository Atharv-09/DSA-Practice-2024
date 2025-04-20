//Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

import java.util.*;
public class LeaderInArray {
    // Brute force approach
    // TC : O(N^2)
// using 2 for loop check each element is greater then its rightmost element if yes then add it to ans
        // TIME : O(N^2) Space : O(N) -> for ans
    public static ArrayList<Integer> 
                     printLeadersBruteForce(int[] arr, int n){
    
        ArrayList<Integer> ans= new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            boolean leader = true;

            //Checking whether arr[i] is greater than all 
            //the elements in its right side
            for (int j = i + 1; j < n; j++)
            if (arr[j] > arr[i]) {
                
                // If any element found is greater than current leader
                // curr element is not the leader.
                leader = false;
                break;
            }

            // Push all the leaders in ans array.
            if (leader)
            ans.add(arr[i]);

        }
        
        return ans;
        
        }
    
    static void findLeaderInArray(int[] arr,int n){

        

        int maxEleToRight = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(arr[i] > maxEleToRight){
                ans.add(arr[i]);
                maxEleToRight = arr[i];
            }
        }
        // If we want ans as the order they gave in input we can reverse using COllections.reverse(arr) and return
        // or else we can use stack to store the elements and then pop and store it to ans arrayList

        
        for(int i:ans){
            System.out.print(i+" ");
        }

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{10, 22, 12, 3, 0, 6};

        findLeaderInArray(arr,arr.length);
    }
}
