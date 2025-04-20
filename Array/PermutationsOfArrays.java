// permutations of [1,2,3] = > {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}
import java.util.*;
public class PermutationsOfArrays {
    


    // Approach-I using extra space for DS and Vis array
    // TIME : O(n! x n) we will have n! permutation and for each element we are going deep

    // SC : O(N) + O(N) [vis and ds]


    public static void permuteRecur1(int[] arr,int n,List<Integer> ds,boolean[] vis,List<List<Integer>> ans){

        //base
        if(ds.size() == n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<n;i++){
            
            if(!vis[i]){
                ds.add(arr[i]);
                vis[i] = true;
                permuteRecur1(arr, n, ds, vis, ans);
                vis[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

    public static void permute1(int[] arr,int n){

        List<Integer> ds = new ArrayList<>();
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        permuteRecur1(arr,n,ds,vis,ans);

        for(List<Integer> list : ans){

            for(int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    // Approach II - Withouut using any DS or anything to store [We will SWAPPING the things]
    // OPTIMIZE SPACE 
    
    // TC : O(N! x N) n! permutation and n loop
    // SC : O(1)

    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void permuteRecur2(int index,int[] arr,int n,List<List<Integer>> ans){
        
        if(index == n){

            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<n;i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
        }

        for(int i=index;i<n;i++){

            swap(arr,i,index);
            permuteRecur2(index+1,arr, n,ans);
            swap(arr,i,index);
        }

    }
    public static void permute2(int[] arr,int n){

        List<List<Integer>> ans = new ArrayList<>();

        permuteRecur2(0,arr,n,ans);

        for(List<Integer> list : ans){

            for(int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,6,2,3};
        // permute1(arr, arr.length);
        permute2(arr, arr.length);
    }
}
