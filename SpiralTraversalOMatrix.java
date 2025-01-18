import java.util.ArrayList;

public class SpiralTraversalOMatrix {
    
    public static void printSpiralMatrix(int[][] arr,int n,int m){


        int top = 0,left=0,right=m-1,bottom=n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(top<=bottom && left<=right){

            // print first row
            for(int i=left;i<=right;i++){
                ans.add(arr[top][i]);
            }
            top++;
            // print last column
            for(int i=top;i<=bottom;i++){
                ans.add(arr[i][right]);
            }
            right--;
            // print bottom row
            if(top <= bottom){
                for(int i=right;i>=left;i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }
            // print left col
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    ans.add(arr[i][left]);
                }
                left++;
            }
            

        }

        for(int a : ans){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        
        int[][] arr = new int[][]{{ 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }};

        
        printSpiralMatrix(arr,arr.length,arr[0].length);
    }
}
