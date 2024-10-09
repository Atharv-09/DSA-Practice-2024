package BS;
/*Problem Statement: You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].


The floor of x is the largest element in the array which is smaller than or equal to x. ->  largest element in the array <= x)
The ceiling of x is the smallest element in the array greater than or equal to x.  -> smallest element in the array >= x*/

// ex : n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5 [floor : 4, ceil : 7]
// ex : n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8 [floor=8, ceil=8]

import java.util.*;
public class FloorAndCeil {

    public static void findFloor(int[] arr,int low,int high,int element){

        int floor = -1;
        while(low <= high){

            int mid= (low+high)/2;
            // get lowest and go to highest side
            if(arr[mid] <= element){ // if curr element greater then element then consider that as floow and check is thier any other element greater then that
                floor = arr[mid];
                low = mid+1;
            }else{ // if curr element greater then element then no need to go to right size coz we want smallest
                high = mid-1;
            }
        }
        System.out.println(floor);
    }
    // same as lower bound
    public static void findCeil(int[] arr,int low,int high,int element){
        
        int ceil = -1;
        while(low <= high){
            int mid = (low+high)/2;
            // get higest and go to lowest side
            if(arr[mid] >= element){
                ceil = arr[mid];
                high = mid-1; // go to left side to get smallest element greater then element
            }else{
                low = mid+1;
            }
        }

        System.out.println(ceil);
    }
    // floor and ceil in same 
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        
        Arrays.sort(arr);
        int left = 0;
        int n = arr.length;
        int right = n-1;
        int floor=-1,ceil=-1;
        
        while(left <= right){
            
            int mid = (left+right)/2;
            
            if(arr[mid] == x){
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
            if(arr[mid] < x){
                floor = arr[mid];
                left = mid+1;
            }else{
                ceil = arr[mid];
                right = mid-1;
            }
        }
        return new int[]{floor,ceil};
        
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,5,6,7,8,19,20,34};

        findFloor(arr,0,arr.length,19);
        findCeil(arr,0,arr.length,19);

    }
}
