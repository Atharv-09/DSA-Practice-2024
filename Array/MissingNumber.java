
// Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
import java.util.*;

public class MissingNumber {
    

    // XOR method
    // as the XOR of sae numner is 0 and xor of no ^ 0 = no
    // [1,3,2,5] ^ [1,2,3,4,5] -> 4

    public static void findMissing5(int[] arr,int n){

        int xor1 = 0;
        for(int i=0;i<n;i++){
            xor1 ^= i;
        }

        
        int xor2 = 0;
        for(int i=0;i<n-1;i++){
            xor1 ^= arr[i];
        }

        System.out.println(xor1 ^ xor2);

        /*

        // using xor
        int xor1=0,xor2=0;
        for(int i=0;i<n;i++){

            xor1 = xor1 ^ i;
            xor2 = xor2 ^ nums[i];
        }
        xor1 = xor1 ^ n;
 */
    }

    // SUMMATION method

    // arr = [1,3,5,2,8,7,4] n = 8
    // sum of all elements in arr  = 30 and sum of element from 1 to n = 36
    // Time : O(N) space : O(1)
    public static void findMissing4(int[] arr,int n){
        
        int totalSum1toN = (n*(n+1))/2;

        int totalSumArr = 0;
        for(int i=0;i<n-1;i++){
            totalSumArr += arr[i];
        }

        System.out.println(totalSum1toN-totalSumArr);
    }

    // USING HASING
    // HASH the keys and thier values if some key value will be 0 that is missing
    // TIME : O(N) SPACE : O(N)

    public static void findMissing3(int[] arr,int n){

        int[] hash = new int[n+1];
        for(int i=0;i<n-1;i++){
            hash[arr[i]]++;
        }

        for(int i=1;i<=n;i++){
            if(hash[i] == 0){
                System.out.println("Missing nuber " + i);
                break;
            }
        }
    }
    // USING SORTING THE ARRAY
    // TIME : O(Nxlogn)
    public static void findMissing2(int[] arr,int n){

        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i] != (i+1)){
                System.out.println("Missing number : " + (i+1));
                break;
            }
        }
    }


    // TIME : O(N*N) SPACE : O(1)
    // LINEAR SEARCH EACH ELEENT
    public static void findMissing1(int[] arr,int n){

        for(int i=1;i<=n;i++){
            boolean found = false;
            for(int j=0;j<arr.length;j++){
                if(arr[j] == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Missing no : " + i);
                break;
            }
        }

        System.out.println("No nuber issing");
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,0,1};
        findMissing5(arr, arr.length+1);
    }
}

// 1 2 3 4 5 6 8