import java.util.ArrayList;
import java.util.List;

public class PrintPermuationsArray {


    void print(int[] arr,List<List<Integer>> ans,int index,boolean[] vis,List<Integer> dum){
        
        if(index>=arr.length){
            ans.add(dum);
            return;
        }

        if(!vis[index]){
            vis[index] = true;
            dum.add(index,arr[index]);
            print(arr,ans,index+1,vis,dum);
            dum.remove(index);
            vis[index] = false;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        boolean[] vis = new boolean[arr.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> dum = new ArrayList<>();
        new PrintPermuationsArray().print(arr,ans,0,vis,dum);


        for(List<Integer> list : ans){
            for(int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
