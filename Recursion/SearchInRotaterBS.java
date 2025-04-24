package Recursion;

public class SearchInRotaterBS {

    int helper(int[] arr,int s,int e,int t){

        if(s>e) return -1;
        int mid = s +(e-s)/2;

        if(arr[mid] == t) return mid;
        if(arr[s] <= arr[mid]) {
            if (arr[s] <= t && t <= arr[mid]) {
                //left part sort and targer is thier
                return helper(arr, s, mid - 1, t);
            } else {
                return helper(arr, mid+1, e,t);
            }
        }else{
            if (arr[mid] <= t && t <= arr[e]) {
                //right part sort and targer is thier
                return helper(arr, mid+1, e,t);
            } else {
                return helper(arr, s, mid - 1, t);
            }
        }
    }
    void find(int[] arr,int n,int t){
       int index = helper(arr,0,n-1,t);
        System.out.println(index);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,6,7,8,9,1,2,3};
        new SearchInRotaterBS().find(arr,arr.length,2);
    }
}
