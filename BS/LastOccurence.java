package BS;

public class LastOccurence {
    

    // Optimal-1 (Using Upperbound and lowerbound concept)
    // Tie : O(logn)+O(logn)
    static int upperBound(int[] arr,int n,int target){
        int low = 0;
        int high = n-1;
        int index = -1;
        // upper bound 
        while(low <= high){

            int mid = (low+high)/2;
            if(arr[mid]>target){
                index = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return index;
    }
    static int lowerBound(int[] arr,int n,int target){
        int low = 0;
        int high = n-1;
        int index = -1;
        // upper bound 
        while(low <= high){

            int mid = (low+high)/2;
            if(arr[mid]>=target){
                index = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return index;
    }
    static void findLastOcc(int[] arr,int n,int target){

        int upperBound = upperBound(arr,n,target);
        int lowerBound = lowerBound(arr,n,target);

        if(lowerBound==arr.length || arr[lowerBound]!=target){
            System.out.println(-1+" "+-1);
        }
        System.out.println("First occurence at index : " + lowerBound +" Last occurence at index : " +(upperBound-1));
    }


    // Optimal-2 
    // By taking binary search
    // taking mid and check if its eql to target then go the the righest side to get the last occurence and if mid > target then it emans element is at left side
    static void findLastOcc1(int[] arr,int n,int target){
        int low = 0;
        int high = n-1;
        int index = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                index = mid;
                low = mid+1;
            }else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        System.out.println(index);
    }   
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,4,13,13,13,20,40};
        findLastOcc1(arr,arr.length,13);
    }
}
