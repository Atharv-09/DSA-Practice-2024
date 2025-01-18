package BS;
//Problem Statement: You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.
// If the value is present in the array, then return its index. Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.
public class SearchInsertPosition {
    
    public static void searchInsertIndex(int[] arr,int low,int high,int ele){

        int index = -1;

        while(low <= high){
            int mid = (low+ high)/2;
            
            if(arr[mid] >= ele){ // either the currEleent can be lower bound or we will go left side to get the closest element >= ele 
                index = mid;
                high = mid-1; // go to the leftest side to get the closer element index
            }else{
                // if mid is lesser then element no need to go left side coz lower bound will be on right
                low = mid+1;
            }
        }

        System.out.println(index);
    }

    public static void main(String[] args) {
        
        int[] arr= new int[]{3,5,7,9,12,18,20};
        searchInsertIndex(arr,0,arr.length-1,1);
    }
}
