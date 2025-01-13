package BS;

public class SearchInSorted2DMatrix {
    
        // brute force using 2 for loops and check
        // TC : O(m*n)

    // better approach - instead of checking all the rows just check target is liening in which row and search into that row
    // TC : O(N+logm)

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix[0].length;
        for(int i=0;i<matrix.length;i++){

            if(target>= matrix[i][0] && target<= matrix[i][m-1]){
                int low = 0;
                int high = m-1;

                while(low <= high){
                    int mid = low + (high-low)/2;
                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] > target) high = mid-1;
                    else low = mid+1;
                }
                break;
            }
        }
        return false;
    }

    public static boolean searchELement(int[][] arr,int n,int m,int target){

        
        // Optimal - we can flatten the 2d matrix int0 1d matrix we can simply binary search the array in O(n+m) time
        // TC : O(log(M*N))

        // index 5 in 1d matrix will be (5/m,5%m) = (5/3,5%/3) = (1,2) 
        // so index 5 element of 1d matrix will be at index (1,2) of 2d matrix

        int low = 0;
        int high = n*m-1;

        while(low <= high){

            int mid = (low+high)/2;

            int x = mid/m;
            int y = mid%m;

            if(arr[x][y] == target) return true;
            else if(arr[x][y] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{1,4,6,7},{8,9,11,13},{15,17,19,34}};

        System.out.println(searchELement(arr,arr.length,arr[0].length,19));
    }
}
