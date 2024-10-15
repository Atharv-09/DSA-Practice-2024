package BS;

public class PeakElementII {
    
    static int findLargest(int[][] arr,int n,int m){
        int maxELe = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<n;i++){
            if(arr[i][m] > maxELe){
                maxELe = arr[i][m];
                index = i;
            }
        }
        return index;
    }
    static void findPeak(int[][] arr,int n,int m){

        // Brute  - we will traverse the arr and check surrondings is that less then the element
        // O(nxm)x4 (for every element we are checking 4 surrounding)

        // Better - We can say that the peak element is the largest elemnt in the array so we will find the largest element
        // TC : O(mxn)
        

        // optimal : 
        int low = 0;
        int high = m-1;

        while(low <= high){

            int mid = (low+high)/2;

            int rowNoOfMaxELeofCOl = findLargest(arr,n,mid);
            int left = mid-1 >= 0 ? arr[rowNoOfMaxELeofCOl][mid-1] : -1; // if the left is thier means all 4 sides are thier
            int right = mid+1 < m ? arr[rowNoOfMaxELeofCOl][mid+1] : -1;
            // we tried to sort it down to the 1d array and do the sol
            if(arr[rowNoOfMaxELeofCOl][mid] > left && arr[rowNoOfMaxELeofCOl][mid] > right){
                System.out.println(arr[rowNoOfMaxELeofCOl][mid]);
                return;
            }else if(arr[rowNoOfMaxELeofCOl][mid] < left){
                high = mid-1;
            }else{
                low = mid+1; 
            }
        }
    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{1,4},{3,2}};

        findPeak(arr,arr.length,arr[0].length);

    }
}
