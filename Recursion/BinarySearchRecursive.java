package Recursion;

public class BinarySearchRecursive {

    public static void main(String[] args) {

        int x = new BinarySearchRecursive().search(new int[]{4,5,8,10,12,18,30,39},0,7,5);
        System.out.println(x);
    }

    int search(int[] arr,int s,int e,int target){

        int mid = s+(e-s)/2;

        if(target == arr[mid]){
            return mid;
        }
        if(arr[mid] > target)
            return search(arr,s,mid-1,target);
        return search(arr,mid+1,e,target);
    }
}
