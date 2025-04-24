package Recursion;

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

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,2,9,12,2};
        boolean ans = new FindTargetInArray().find(arr,12,0);
        System.out.println(ans);
        int index = new FindTargetInArray().findIndex(arr,12,0);
        System.out.println(index);
    }
}
