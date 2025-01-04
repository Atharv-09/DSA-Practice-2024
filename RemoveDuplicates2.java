// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

public class RemoveDuplicates2 {
    
    public int removeDuplicates(int[] nums) {
        
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int k = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(val == 1){
                nums[k++] = key;
            }else if(val >= 2){
                nums[k++] = key;
                nums[k++] = key;
            }
        }
        return k;
    }

    // Opotimal ccomplex method 
    public int removeDuplicates1(int[] nums) {
        
        int x = 0, y=0;
         int n = nums.length;
         int newVal = 0;
 
         int count = 0;
 
        while(y<n){
             
             while(y<n && nums[y] == nums[newVal]){
                 count++;
                 y++;
             }
             if(count == 1){
                 nums[x++] = nums[y-1];
             }
             else{
                 nums[x++] = nums[y-1];
                 nums[x++] = nums[y-1];
             }
             newVal = y;
             count = 0;
        }
        return x;
     }

     public int removeDup(int[] arr){
        
        int k = 0;

        for(int x : arr){
            if(k<2 || x != arr[k-2])
                arr[k++] = x;
        }
        return k;
     }

}
