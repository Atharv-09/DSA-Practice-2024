import java.util.*;
public class SorttArrays012 {
    


    // 1. Using sorting tehcnique
    // TIME : O(NLOGN)

    // 2 . Take count of 0,1,2 and then put that from 0 to count of 0 = 0 , last index to count of 1 = 1 , last index to counf of 2 = 2
    // TIME: O(N) SPACE: O(1)
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) cnt0++;
            else if (arr.get(i) == 1) cnt1++;
            else cnt2++;
        }

        //Replace the places in the original array:
        for (int i = 0; i < cnt0; i++) arr.set(i, 0); // replacing 0's

        for (int i = cnt0; i < cnt0 + cnt1; i++) arr.set(i, 1); // replacing 1's

        for (int i = cnt0 + cnt1; i < n; i++) arr.set(i, 2); // replacing 2's

    }


    // Using  Dutch National flag algorithm. [THREE POINTER ALGO]
    // TIME : O(N) SPACE : O(1) 
    /* arr[0….low-1] contains 0. [Extreme left part]
arr[low….mid-1] contains 1.
arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array*/

    public static void sortArr(int[] arr,int n){

        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high){

            if(arr[mid] == 1) mid++;
            else if(arr[mid] == 0){
                swap(arr,mid,low);
                low++;mid++;
            }else{
                swap(arr,mid,high);
                high--; 
                // mid++; removed for 1 edge case below -> 
                // bub it fails for given input [1,2,0]
                // coz when low = 1 mid=1 then we increment mid so now mid at 2nd position
                // at mid = 2 is thier which we need to swap with high
                // it becomes 1 0 2 then mid increase to 3 which is greater then then mid so break
                // to prevent remove this mid++ increment in this condition

            }
        }

    }
    public static void swap(int[] arr,int p1,int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }    
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,0};
        // ArrayList<Integer> arr1 = Arrays.asList(arr);
        // sortArray(arr1,arr1.size());
        sortArr(arr,arr.length);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
