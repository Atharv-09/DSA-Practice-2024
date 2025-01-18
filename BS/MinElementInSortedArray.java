package BS;
/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array. 
 arr = [4,5,6,7,0,1,2,3] - min = 0
  arr = [3,4,5,1,2] min - 1 
*/
public class MinElementInSortedArray {

    // Approach -1 we will check mid as it contains distinct value one of the side is sorted
    // so take the min (lowest element) from the sorted side and keep it at min and ignore that sorted side
    public static void minElement(int[] arr,int n){

        int left = 0;
        int right = n-1;
        int minElementIs = Integer.MAX_VALUE;

        while(left <= right){

            int mid = left+(right-left)/2;
            //search space is already sorted
            //then arr[low] will always be the minimum in that search space:
            if (arr[left] <= arr[right]) {
                minElementIs = Math.min(minElementIs, arr[left]);
                break;
            }

            // left part sorted
            if(arr[left] <= arr[mid]){
                // take the minimum element from that sorted part i.e arr[left] and the prev min
                minElementIs = Math.min(arr[left],minElementIs);
                left = mid+1; // we will ignore the sorted left part
            }else{
                // 5 6 7 0 1 2 3 [here as mid = 0 that means the right part is sorted so we take min Element from right part(i.e 0 here) and prev min]
                minElementIs = Math.min(arr[mid],minElementIs);
                right = mid-1; // ignore the sorted right part.
            }
        }

        System.out.println(minElementIs);

    }

    // Approach 2
    // 1. if the current mid element is less then its [mid-1] element
    // 2. If the current mid element is greater then [low] element (arr[mid] <= arr[mid]) [left part sorted] and [mid] element greater then [high] element
    // 5,6,7,8,9,1,4] // here 8>5 && 8>4 go to right side
    // 3. else go to lef [5,0,1,2,3,4,5];
    public static int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{3,1,2};

        minElement(arr,arr.length);
        findMin(arr);
    }
}
