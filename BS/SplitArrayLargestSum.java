package BS;
/*Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
A subarray is a contiguous part of the array. */
// similar to that book allocation problem
// here we have to split array into k non-empty subarrays and in that we have to split books among m students
// as they non empty subarray here in that we have each student have at least 1 book

/* N = 5, a[] = {1,2,3,4,5}, k = 3  . result = 6
[1 | 2 | 3,4,5] - > max of them = 12
[1 | 2 3 4 | 5] = max = 9
[1 2 3 | 4 |5 ] = max = 6 
and MIN of all of them  = 6
here we can go to make low as maximum element and high as the sum of element such that we can create one whole array when k=1
 */

public class SplitArrayLargestSum {
    
    public static boolean check(int[] arr,int n,int maxSum,int k){

        int sumTN = 0;
        int subArrCount = 1;
        for(int i=0;i<n;i++){

            int sum = arr[i]+sumTN;
            if(sum > maxSum){                //insert element to next subarray
                subArrCount++;
                sumTN = arr[i];
            }else{                //insert element to current subarray
                sumTN += arr[i];
            }
        }

        if(subArrCount <= k) return true;
        else return false;
    }
    public static int splitArray(int[] arr,int k){
        int n = arr.length;
        if(k > n) return -1;

        int low = Integer.MIN_VALUE; // lowest value we take th maximum value in array
        int high = 0; // higghest we take the totalSum of array

        for(int i=0;i<n;i++){
            low = Math.max(low,arr[i]);
            high += arr[i];
        }
        System.out.println(low+" "+high);
        for(int val=low;val<=high;val++){
            if(check(arr,n,val,k)){
                return val;
            } 
        }
     return -1;
    }
    
    public static int splitArray1(int[] arr,int k){

        int n = arr.length;
        if(k > n) return -1;

        int low = Integer.MIN_VALUE; // lowest value we take th maximum value in array
        int high = 0; // higghest we take the totalSum of array

        for(int i=0;i<n;i++){
            low = Math.max(low,arr[i]);
            high += arr[i];
        }

        while(low <= high){

            int mid = (low+high)/2;

            if((check(arr,n,mid,k))){
                high = mid-1;
            }else{ 
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(splitArray(arr,3));
    }
}
