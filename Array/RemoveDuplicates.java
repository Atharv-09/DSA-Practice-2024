import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    


    public static void main(String[] args) {
        
        int[] arr = new int[] {1,1,2,2,2,2,2,2,4,5,6,6,6,6,9};
        int index =  removeUsingTwoPointer(arr,arr.length);
        // int index = removeUsingHashSet(arr,arr.length);

        for(int i=0;i<index;i++){
            System.out.print(arr[i] +" ");
        }
    }


    // TIME : O(N) SPACE : O(N)
    static int removeUsingHashSet(int[] arr,int n){

        Set<Integer> set  = new LinkedHashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }

        int k = set.size();
        int m = 0;
        for(int x:set){
            arr[m++] = x;
        }

        return k;
    }
    static int removeUsingTwoPointer(int[] nums,int n){

        int index = 0;
        for(int i=1;i<n;i++){

            // Other pointer p2 moves till we wont get new element
            if(nums[i] == nums[index]) continue; // ADDED BY ME - NOT NEEDED 
            
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
