import java.util.*;
import java.util.Map.Entry;

public class HashMapEx {
    
    static void func(int[] arr,int n){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println(entry.getKey() +" "+entry.getValue());
        }
        
    }
    public static void main(String[] args) {
        
        int[] arr = {1,1,1,2,2,2,3,3,4,5,5,5};

        func(arr,arr.length);
    }
}
