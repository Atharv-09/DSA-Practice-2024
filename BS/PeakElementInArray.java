package BS;
/*Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its neighbors. Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
     arr[] = {1,2,3,4,5,6,7,8,5,1} peak at index = 7 i.e 8
     arr[] = {1,2,1,3,5,6,4} peak at index 1,5 i.e 2,5
 */
public class PeakElementInArray {
    
    // Brute force : TC : O(N)

    public static void getPeakElement(int[] arr,int n){
        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr[i - 1] < arr[i])
                    && (i == n - 1 || arr[i] > arr[i + 1])) {
                System.out.println(arr[i]);
                return;
            }
        }
    }
    // OPtimal 
    // Using binary search
    // suppose we have only 1 peak in arr 1 2 3 4 5 6 7 8 4 1

    public static int getPeakElement1(int[] arr,int n){

        // if array is hving only 1 element
        if(n==1) return arr[0];
        // first element is peak - if its greater then its next element, as prev element is -ve infinity
        if(arr[0]>arr[1]) return arr[0];
        // last element is peak - it ites greater then its prev elemen, as next element is -ve infinity
        if(arr[n-1]>arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-1;

        while(low <= high){

            int mid = (low+high)/2;
            
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return arr[mid]; // its peak element
            else if(arr[mid-1]<arr[mid]){
                //elminate left part as the peak is on riht side
                low = mid+1;
            }else if(arr[mid] > arr[mid+1]){
                high = mid-1;
            }else{
                // if we have multiple peaks 1 5 1 2 1 here mid =1 no one else execute so it goes infinite so either go left or go right either side we will get peak element
                low = mid+1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,3,1,7,1,4,1};

        System.out.println(getPeakElement1(arr,arr.length));
    }
}
