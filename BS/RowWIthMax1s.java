package BS;

public class RowWIthMax1s {

    public static int getRows(int[][] arr,int n,int m){
        // Brute force we use 2 loops and check each ith rows who ever is maimum 1 we will return that row
        // TC : O(n+m)

        // Optimal 
        int max1s = 0,index=-1;
        for(int i=0;i<n;i++){

            int low = 0;
            int high = m-1;

            while (low<=high){

                int mid = (low+high)/2;
                if(arr[i][mid] >= 1){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            if((m-low) > max1s){
                index = i;
                max1s = m-low;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        
        int[][] arr  = new int[][]{{0,0,0,0,0,1,1},{0,0,1,1,1,1,1}};

        System.out.println(getRows(arr,arr.length,arr[0].length));
    }
}
