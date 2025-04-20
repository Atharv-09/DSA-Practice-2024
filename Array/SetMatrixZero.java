import java.util.ArrayList;

public class SetMatrixZero {
    


    // 1. Approach BRUTE 
    // Time : O(NxM)*O(N+M)
    // Space : O(N+M)
    public static void setMatrixZero1(int[][] arr,int n){

        boolean[][] vis = new boolean[n][arr[0].length];

        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;j++){

                if(arr[i][j] == 0 && !vis[i][j]){

                    for(int m=0;m<n;m++){
                        arr[m][i] = 0;
                        vis[m][i] = true;
                    }
                    for(int k=0;k<arr[i].length;k++){
                        arr[i][k] = 0;
                        vis[i][k] = true;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Approach 2  : We can optimize that boolean array space complexity by making the array element as -ve 
    // If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
    // NOTE : work when array having only +Ve elements
    // Time : O(NxM)*O(N+M)
    // Space : O(1)


    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }
    public static void setMatrixZero2(ArrayList<ArrayList<Integer>> matrix, int n, int m){

        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        // Finally, mark all -1 as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
    }

    //In the previous approach, we were marking the cells with -1 while traversing the matrix. But in this approach, we are not marking the entire row and column instead, we are marking the ith index of row array i.e. row[i], and jth index of col array i.e. col[j] with 1. These marked indices of the two arrays, row and col will tell us for which rows and columns we need to change the values to 0. For any cell (i, j), if the row[i] or col[j] is marked with 1, we will change the value of cell(i, j) to 0.
    // Approach -3 
    // we will take the rows/cols which we have to mark as zero
    // TIME : O(NxM)+O(NxM)
    // SPACE : O(N+M)
    public static void setMatrixZero3(int[][] matrix, int n, int m){

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(row[i] == 1 || col[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

    }

    // OPTIMAL
    // Approach - 4
    // We can optimize the space complexity to O(1) but the time complezity above is already optimized
    // Instead of taking other space row/col to mark as the particular row we have to do as 0 we can take row[0]/col[0] as the marking index
    // row[n]  = matrix[..][0]
    // col[m] = matrix[0][..]

    public static void setMatrixZero4(int[][] matrix, int n, int m){

        // marking the indexes
        int col0 = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j!=0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // we will traverse t+1 and j+! index to last and check particular row/col having zero change the indexes from 1 to 0

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

                if(matrix[i][j] !=0 ){
                    if(matrix[i][0] == 0 || matrix[0][j] ==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }


        // now we will check for the index for the first row and first col which we used as the row and col index 
        // when all the row 0 elemnt become 0 when the first col element is 0 
        if(matrix[0][0] == 0){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }
        // ans then first column dependns on itself and the col1 
        if(col0 == 0){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
        // print the result
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //{0,1,2,0},{3,4,5,2},{1,3,1,5}
        setMatrixZero4(arr,arr.length,arr[0].length);
        // System.out.println(arr[0].length);
    }
}
