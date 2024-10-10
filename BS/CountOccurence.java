package BS;

public class CountOccurence {

    public static int findFirstOcc(int[] arr,int low,int high,int k){
        int firstOccIndex = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == k){
                firstOccIndex = mid;
                high = mid-1;
            }else if(arr[mid] > k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return firstOccIndex;
    }
    public static int findLastOcc(int[] arr,int low,int high,int k){
        int lastOccIndex = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == k){
                lastOccIndex = mid;
                low = mid+1;
            }else if(arr[mid] > k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return lastOccIndex;
    }
    public static int[] firstAndLastPos(int[] arr,int n,int x){
        
        int first = findFirstOcc(arr,0,n-1,x);
        if(first == -1) return new int[]{-1,-1};
        int last = findLastOcc(arr,0,n-1,x);
        return new int[]{first,last};
        
    }
    static void countOcc(int[] arr, int n, int x) {
        // code here
        int[] ans = firstAndLastPos(arr,n,x);
        if(ans[0] == -1){
            System.out.println(0);
            return;
        }
        System.out.println(ans[1]-ans[0]+1);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,3,3,3,4,4,4,4,4,6};
        
        countOcc(arr,arr.length,8);
    }
}
