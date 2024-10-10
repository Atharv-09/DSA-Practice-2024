package BS;

/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated. 
    ex : arr = 4,5,6,7,0,1,2,3  op=4
    ex : arr = 3,4,5,1,2 op = 3
    arr = 5 1 2 3 4 op = 1
    arr = 
 */

 // SAME AS MININUM ELEMENT IN ARRAY (JUst here we have to find min Element index)

public class ArrayRotationTime {
    

    public static void minElement(int[] arr,int n){

        int low = 0;
        int high = n-1;

        while(low <= high){

            int mid = low+(high-low)/2;

            if(mid >0 && arr[mid-1] > arr[mid]){
                System.out.println(mid);
                return;
            }
            if(arr[low] <= arr[mid] && arr[mid] > arr[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        System.out.println(arr[low]);

        
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,4,5,5,5,6,1,2};

        minElement(arr,arr.length);
    }

}
