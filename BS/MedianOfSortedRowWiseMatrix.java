package BS;

public class MedianOfSortedRowWiseMatrix {
    // brute force : 
    // convert this array into 1d array and then get median
    // TC :  O(MXN) + O(MXN(log(MXN))) sp : O(n+m)

    // optimal 
    //O(log(109)) X O(M(logN))
    static int upperBound(int[] arr,int ele){

        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            int mid = (low+high)/2;
            if(arr[mid] > ele){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    static int blackBox(int[][] arr,int mid){

        // we have to check this mid element how many elements are smaller then this
        // we can travser the matrix but the time complexity will go O(nxm) so 
        // for each row you can take the upper bound of the mid element
        int count = 0;
        for(int i=0;i<arr.length;i++){

            int index = upperBound(arr[i],mid);
            count += index;
        }
        return count;
    }
    static int findMedianOfSortedRowWiseMat(int[][] arr,int n,int m){
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            low = Math.min(arr[i][0],low);
            high = Math.max(arr[i][m-1],high);
        }

        int required = (n*m)/2;
        while (low <= high){

            int mid = (low+high)/2;
            int smallerEquals = blackBox(arr,mid); // how many element are smaller or equal to the mid 

            if(smallerEquals <= required){ // means if we want x element on the left side of median element and we have less elemenet we will go right side
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{10,13,14,17,24}};
        // 1 2 4 5 7 8 10 11 12 13 14 15 19 17 24
        int ans= findMedianOfSortedRowWiseMat(arr,arr.length,arr[0].length);

        System.out.println(ans);
    }
}
