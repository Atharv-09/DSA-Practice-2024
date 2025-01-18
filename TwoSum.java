import java.util.*;
public class TwoSum {

    // check linear search using 2 or loops
    // TIME : O(N^2) Space : O(1);


    // Using Sorting 
    // O(Nlogn) 
    void checkSum1(int[] arr,int n,int target){

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = n-1;

        while(p1<p2){

            int sum = arr[p1] + arr[p2];
            if(sum == target){
                System.out.println("Yes at index : " + p1 + " " + p2);
                return;
            }else if(sum < target){
                p1++;
            }else{
                p2--;
            }
        }

        System.out.println("Not found");

    }

    // Using HashMap
    // TTIME: O(n) SPACE :O(N)

    // Optimal for variant that needs the indexs of elements
    void checkSum(int[] arr,int n,int target){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int ele = target-arr[i];
            if(map.containsKey(ele)){
                System.out.println("YES at index x:" + i +" y: " + map.get(ele));
                return;
                // break;
            }
            map.put(arr[i],i);
        }

        System.out.println("NO");
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,1,3,6,8,12,7,11,15};
        new TwoSum().checkSum1(arr, arr.length, 12);
    }
}
