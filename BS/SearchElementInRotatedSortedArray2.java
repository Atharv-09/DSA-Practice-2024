package BS;
/*Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False. 
 arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3 TRUE
  arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10 FALSE
*/
public class SearchElementInRotatedSortedArray2 {
    public static void searchElement(int[] arr,int n,int k){

        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == k){
                System.out.println(true);
                return;
            }
            if(arr[mid] == arr[left] && arr[left] == arr[right]){
                left++;
                right--;
                continue;
            }
            if(arr[mid]>=arr[left]){
                //left part sorted
                if(k>=arr[left] && k<=arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //left part sorted
                if(k>=arr[mid] && k<=arr[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        
        }

        System.out.println(false);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,1,2,3,3,3,3};
        searchElement(arr,arr.length,3);
    }
}
