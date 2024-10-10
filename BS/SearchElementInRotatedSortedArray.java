package BS;

/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.

arr = [4,5,6,7,0,1,2,3], k = 0 op = 4
arr = [5,1,3] k =  5 op = 0
arr = [3 4 1 2] k = 5 op = -1

*/
// Key Observation: Though the array is rotated, we can clearly notice that for every index, one of the 2 halves will always be sorted.

public class SearchElementInRotatedSortedArray {
    
    // NOT WORKING FOR SOME INPUTES
    public static void searchElement(int[] arr,int n,int k){

        int left = 0;
        int right =n-1;

        while(left <= right){

            int mid = left+(right-left)/2;
            if(arr[mid] == k){
                System.out.println("At inde : " + mid);
                return;
            }else if(k<arr[mid] && k>=arr[left]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(-1);
    }
    // Above approach fail for input = [5,1,3] target = 5 ans = 0 (but coming -1)
    // Approach 2, as we observe when we are at mid one of the subarray left or right are sorted, we will check if the k lies in sorted part
    // if yes we will go to that sorted part
    // if no we will eliminate that sorted part

    public static void searchElement1(int[] arr,int n,int k){

        int low = 0;
        int high = n-1;
        
        while(low <= high){

            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                System.out.println(mid);
                return;
            }
            // left part sorted
            if(arr[low] <= arr[mid]){
                if(k>=arr[low] && k<=arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                // right part sorted & check if k lies in that go to right side else left side
                if(k>=arr[mid] && k<=arr[high]){
                    low = mid+1;
                }else{
                    high = low-1;
                }
            }
        }
        System.out.println(0);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{4,5,6,8,0,1,2,3};
        searchElement1(arr,arr.length,5);
    }
}

