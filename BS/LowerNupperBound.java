package BS;

// The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

// The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.
public class LowerNupperBound {
    
    // Lower Bound
    // N = 5, arr[] = {3,5,8,15,19}, x = 9 result = 3 [element-15]

    public static void findLowerBound(int[] arr,int low,int high,int ele){

        int lowerBound = 0;

        while(low <= high){
            int mid = (low+ high)/2;
            
            if(arr[mid] >= ele){ // either the currEleent can be lower bound or we will go left side to get the closest element >= ele 
                lowerBound = arr[mid];
                high = mid-1;
            }else{
                // if mid is lesser then element no need to go left side coz lower bound will be on right
                low = mid+1;
            }
        }

        System.out.println(lowerBound);
    }

    // Upper Bound [element greater then given eleent]
    // Floor in a Sorted Array
    // N = 6, arr[] = {3,5,8,9,15,19}, x = 9 result = 4 (element-15)


    public static int findUpperBound(long[] arr,int low,int high,long ele){

        long upperBound = 0;
        int index = -1;
        
        while(low <= high){
            int mid = (low+ high)/2;
            
            if(arr[mid] > ele){ // if mid is lesser then element no need to go left side coz lower bound will be on right
                upperBound = arr[mid];
                index = mid;
                high = mid-1;
            }else{ // arr[mid] > ele // either the currEleent can be lower bound or we will go left side to get the closest element >= ele 
                low = mid+1;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        
        int[] arr= new int[]{3,5,7,9,12,18,20};
        findLowerBound(arr,0,arr.length-1,21);
    }
}
