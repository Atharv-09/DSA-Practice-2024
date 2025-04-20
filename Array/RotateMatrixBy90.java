public class RotateMatrixBy90 {
    
    // Using extra space : 
    // TIME : O(N^2)
    // Space : O(2N)
    static void rotate(int[][] rotate,int n){

        int[][] rotated = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotated[j][n-i-1] = rotate[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(rotated[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Optimal
    // take the transpose and reverse the rows of the transpose
    // TIEM : O(N^2)
    // SPace : O(1)
    static void rotate1(int[][] rotate,int n){

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = rotate[i][j];
                rotate[i][j] = rotate[j][i];
                rotate[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            // reverse
            for(int j=0;j<n/2;j++){
                int temp = rotate[i][j];
                rotate[i][j] = rotate[i][n-j-1];
                rotate[i][n-j-1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(rotate[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        rotate1(arr,arr.length);
    }
}
