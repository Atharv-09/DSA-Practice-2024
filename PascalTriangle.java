import java.util.*;
/*
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     */
public class PascalTriangle {
    
    //Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
    // Given r = 6 c = 3 ans = 10 
    
    // BRUTE Force approach : By direct using nCr formula = n! / r! x (n-r)!;
    //  separately caculae n!,r!,(n-r)! and then put it in formula
    // TC : O(n)+O(r)+O(n-r)

    // Optimal Approach
    // TC : O(C) c - given colun number
    static long findnCr(int n,int r){
        // we are considering r-1  as n and c-1 as r
        // as the particular row has row (r) number of elements so we can assume as n = r
            long ans = 1;
            for(int i=0;i<r;i++){
                ans = ans * (n-i);
                ans = ans/(i+1);
            }
            return ans;
    }
    static void pascalT_var1(int r,int c){
        
        int ele = (int) findnCr(r-1,c-1);
        System.out.println("Element at row " + r + " col " + c + " : " + ele);
    }


    //------------------------------------------------------------------------------------------


    // Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
    // Brute Force approach : 
    // we will go from 1 to row numeber and for each col we will call findnCr method
    // TC : O(N) * O(C) -> n = no of elements and c for findnCr()function

    static void pascalTBrute_var2(int row){
        for(int c=1;c<=row;c++){
            System.out.print(findnCr(row-1, c-1)+" ");
        }
        System.out.println();

    }

    // OPTIMAL APPROACH : 
    // using the common element from the prev and and multiplying with such it make the current element
    // Current element = prevElement * (rowNumber - colIndex) / colIndex
    // TC : O(N) (n- no of rows/ row you want ro print count)
    static void pascalTOptimal_var2(int row){

        int ans = 1;
        System.out.print(ans+" ");
        for(int i=1;i<row;i++){
            ans = ans * (row-i);
            ans = ans/i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }
    public static void print(List<List<Integer>> ans){
        for(List<Integer> list : ans){
            for(int x : list){
                System.out.print(x +" ");
            }
            System.out.println();
        }
    }

        //------------------------------------------------------------------------------------------

    //Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
    /*The naive approach is basically a combination of variation 1 and variation 2. Here, for every row from 1 to n, we will try to generate all the row elements by simply using the naive approach of variation 2. So, we will use the same code as variation 2(naive approach), inside a loop (i.e. row runs from 1 to n).*/
    
    // for each row element we will calling ncr function and printing (calling variation 1)
    // we will go from 1st row to the nth row and for each column element we are calling nCr() function to get each element at (row,col)

    // BRUTE Force :
    // TC : O(NxNxR) - O(N^3)
    static void pascalTBrute_var3(int n){

        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 1;row<=n;row++){
            List<Integer> temp = new ArrayList<>();
            for(int col=1;col<=row;col++){
                temp.add((int)findnCr(row-1, col-1));
            }
            ans.add(temp);
        }
        print(ans);
    }

    // OPTIMAL Approach
    // TC : O(N^2)
    // Instead of generating each values using that nCr function we can generate each row using variation 2
    static List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for(int col=1;col<row;col++){
            ans = ans * (row-col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    static void pascalTOptimal_var3(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> rowI = generateRow(i);
            ans.add(rowI);
        }
        print(ans);
    }

    public static void pascalTriangleCombinationMethod(int rows){

        if(rows == 0) return;

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);

        
        
        for(int i=1;i<rows;i++){
            List<Integer> prevRow = ans.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            
            currentRow.add(1);
            for(int j=1;j<i;j++){
                currentRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currentRow.add(1);            
            ans.add(currentRow);
        }

        print(ans);
            
    }
    public static void main(String[] args) {
        
        int n = 3;
        // pascalT_var1(6,3);
        // pascalTBrute_var2(6);
        // pascalTOptimal_var2(5);

        // pascalTBrute_var3(7);
        // pascalTOptimal_var3(5);

        pascalTriangleCombinationMethod(5);
    }

}
