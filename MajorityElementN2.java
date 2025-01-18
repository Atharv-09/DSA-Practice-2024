//Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

import java.util.*;
import java.lang.*;
public class MajorityElementN2 {
    

    // BRUTE
    // SUING 2 for loop loop each element and check count is > N/2 return
    // TIME : O(N^2) SPACE: O(1)
    public static void findMajorityElement(int[] arr,int n){


        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            int toBe = (int) Math.floor(n/2);
            if(count > toBe){
                System.out.println(arr[i]);
                break;
            }
        }
    }

    // Added hasset as we are checking each element, so thier is repeatation so instead of doing that we can put in hashset and chech before checking count of tht elememt
    // we can see its thier in set then ignore the exectiuon for that eleemnt
    // TIME : O(N^Logn) O(N);
    public static void findMajorityElement1(int[] arr,int n){

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int count = 0;
            if(set.contains(arr[i])) continue;
            for(int j=0;j<n;j++){
                
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            
            int toBe = (int) Math.floor(n/2);
            if(count > toBe){
                System.out.println(arr[i]);
                break;
            }

            if(!set.contains(arr[i])) set.add(arr[i]);
        }
    }

    // Using Sorting 
    // TIME :O(NLOGN) space : O(1)

    // another using sorting is 
    // as we know if thier is majority element so thier is more only one element in array so that element will occur at mi also
    // if array is even n=4 [1,1,2,1] then after soring at mid 1 is comind and for odd length also mid coming the majority element
    
    public static void findMajorityElement2(int[] arr,int n){

        Arrays.sort(arr);
        int count = 1;

        for(int i=0;i<n-1;i++){
            if(arr[i] == arr[i+1]) count++;
            else count = 1;

            if(count > Math.ceil(n/2)){
                System.out.println(arr[i]);
                break;
            }
        }

    }


    // Usng HASHMAP
    // STORE THE COUN OF EACH 
    // TC : O(N) SC : O(N)
    public static void findMajorityElement3(int[] v,int n){

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                System.out.println(it.getKey());
                break;
            }
        }
        System.out.println(-1);
    }

    // OPTIMAL : TC : O(N) SPACE : O(1)
    // Moores Voting algorithm
    // As we know that majority element occurence will be more that the other element so we can consider the majority element as first one
    // then if the same element is thier we will increase the count else we will decrease the count (as they are cancelling out the proportion)
    // so at last some element we get that will not have the pair to cancel out.
    // f the question states that the array must contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if the stored element is the majority element or not. If not, then the array does not contain any majority element.

    
    public static void findMajorityElement4(int[] arr,int n){

        int count = 1;
        int ele = arr[0];
        // OR we can intialize above as 0 ,0 and start loop from 0 to n so that we can first check that condiition of count == 0, then arr[i] == ele and else other one
        for(int i=1;i<n;i++){

            if(arr[i] == ele) count++;
            else count--;

            if(count == 0 ){
                count = 1;
                ele = arr[i];
            }
        }
        // take count to check the element we think is Majority(>N/2)
        count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == ele) count++;
        }
        if(count > Math.floor(n/2)) System.out.println(ele);
        else System.out.println(-1);

    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{2,2,1,1,1,2,3,4,1,1,1,5,6,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8};

        findMajorityElement4(arr,arr.length);
    }
}
