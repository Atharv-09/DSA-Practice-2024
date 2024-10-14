package BS;
//Search in a row and column-wise sorted matrix



/*Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row and each column are sorted in non-decreasing order.
But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not. */

/* N = 5, M = 5, target = 14
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
op false
 */
public class SearchInRownColWiseSortedMAt {
    
    static boolean searchELement(int[][] arr,int n,int m,int target){
        // Brute force - linearly traverse 2d array
        // TC : O(NxM)

        // Better : for each row instead of linear traversing as the rows are sorted use Binary search to search element
        // TC : O(NxlogM)

        // OPtimal
        // As from the observation we can see
        // 1. if we start travesing from cell(0,0) , element both side are increasing so we don't know which side to go either row/col
        // 2. From cell(0,m-1), element to the left side are decreasing and elment to downside are increasing so we can start from here to searcg
        // 3. from cell(n-,m-1), element are decreasing both side row/col so we cannot determine, how to move i.e. row-wise or column-wise. T
        // 4. from cell(n-1,0) eleent are decreasing upward and increasing sideby rightside so we can search from here also 
        // we can take search from any cell(0,m-1) or cell(n-1,0)

        // TC : O(N+M)
        int row = 0;
        int col = m-1;
        // as we are starting from cell(0,m-1)
        while(row < n && col >= 0){
            if(arr[row][col] == target) return true;
            else if(arr[row][col] > target) col++; // as the row is in decreasing order so target may be thier
            else row++; // as the col is in increasing order so target may be thier
        }
        return false;

        //OR If we took row = n-1 and col = 0

        /* 
        int n = matrix.length;
        int m = matrix[0].length;

        if(matrix == null || n<1 || m<1) return false;
        
        int row = n-1;
        int col = 0;
        while(row < n && col < m){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) row--;
            else col++;
        }
        return false; */
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{10,13,14,17,24}};

        System.out.println(searchELement(arr,arr.length,arr[0].length,13));
    }
}
