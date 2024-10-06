//Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

import java.util.*;
public class LeaderInArray {
    
    
    static void findLeaderInArray(int[] arr,int n){

        // using 2 for loop check each element is greater then its rightmost element if yes then add it to ans
        // TIME : O(N^2) Space : O(N) -> for ans

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
