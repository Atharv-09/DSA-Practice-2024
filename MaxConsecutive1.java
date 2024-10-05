import java.util.*;

public class MaxConsecutive1 {
    

    // Using Simple loop and take the count of 1 , as we reach at 0 then check is that last counter of 1 is max or not and put that into maxCount and reset count to 0
    // TIME : O(N) Space : O(1)
    public static void maxConsecutiveOne3(int[] arr,int n){

        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<n;i++){

            if(arr[i] == 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        //but it will fail for below input : [1,1,0,0,1,1,1]
        // here as at end count will be 3 but maxCount is updated before when 0 comes i.e 2 so it will return maxCount as 2 not 3
        // so add max(macxCount,count) if the consecutive 1's comes more at the end of array 

        System.out.println("Max Consecutive Ones : " + Math.max(count,maxCount));
    }
    // HASHMAP
    // TIME :O(N) SPACE : O(N)
    public static void maxConsecutiveOne2(int[] arr,int n){
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int maxCount = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            if(arr[i] == 1){
                map.put(1,map.getOrDefault(1,0)+1);
            }else{
                maxCount = Math.max(maxCount,map.get(1));
                map.put(1,0);
            }
        }

        System.out.println("Max consecutive 1's : " + maxCount);
    }

    // Usingg 2 loops
    // outer will go from 0 to n and inner will track if thier is 1 then how much times that is occuring and the outer index will be updated as
    // TIME : O(N^2)
    
    public static void maxConsecutiveOne(int[] arr,int n){

        int maxCount = Integer.MIN_VALUE;
        int i=0;
        int j = i;
        for(;i<n;i++){
            int count = 0;
            j = i;
            if(arr[i] == 1){
               while(j<n){
                if(arr[j] == 0) break;
                j++;
                count++;
               }
            }
            maxCount = Math.max(maxCount,count);
            i = j+1;
        }
        System.out.println("Max consecutive one's : " + maxCount);
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,1,1,1,1,0,0,0,1,0,1,1,1,1,1,0,0};
        maxConsecutiveOne3(arr,arr.length);
    }
}
