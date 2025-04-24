package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FindTargetInArray {

    boolean find(int[] arr,int target,int i){
        if(i == arr.length-1) return false;
        return arr[i] == target || find(arr,target,i+1);
    }
    int findIndex(int[] arr,int target,int i){
        if(i == arr.length) return -1;
        if(arr[i] == target) return i;

        return findIndex(arr,target,i+1);
    }

    // Find all index of target
    // we can take array list outside and add the ans into that

    ArrayList findAllIndex(int[] arr, int target, int i, ArrayList<Integer> ans){

        if(i == arr.length) return ans;
        if(arr[i] == target) ans.add(i);

        return findAllIndex(arr,target,i+1,ans);
    }

    // other way we can take the arraylist in the reursive function so that thier scope in that function only
    ArrayList<Integer> findAllIndex2(int[] arr,int t,int i){
        ArrayList<Integer> listPerM = new ArrayList<>();
        if(i == arr.length) return listPerM;
        if(arr[i] == t) listPerM.add(i); // contains ans for that funtion call only

        // answer from below calls
        ArrayList<Integer> curr = findAllIndex2(arr,t,i+1);
        listPerM.addAll(curr);
        return listPerM;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,2,9,12,2};
        boolean ans = new FindTargetInArray().find(arr,12,0);
        System.out.println(ans);
        int index = new FindTargetInArray().findIndex(arr,12,0);
        System.out.println(index);


        ArrayList<Integer> index2 = new FindTargetInArray().findAllIndex(arr,2,0,new ArrayList<>());
        System.out.println(index2);

        ArrayList<Integer> index3 = new FindTargetInArray().findAllIndex2(arr,2,0);
        System.out.println(index3);
    }
}
