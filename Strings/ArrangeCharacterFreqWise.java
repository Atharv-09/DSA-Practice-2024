package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ArrangeCharacterFreqWise {
    

    /// normal sorting the values of map
     public String frequencySort(String s) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // t - 1 , r - 1, e -2
        List<Character> list = new ArrayList(map.keySet());
        list.sort((obj1,obj2) -> map.get(obj2)-map.get(obj1));
        // now sort on basis of the value
        for(char ch:list){
            for(int i=0;i<map.get(ch);i++)
                sb.append(ch);
        }
        return sb.toString();
    }
        // using priority queue for sorting 
        public String frequencySort1(String s) {
            Map<Character, Integer> hm = new HashMap<>();
            
            for (char c : s.toCharArray()) {
                hm.put(c, hm.getOrDefault(c, 0) + 1);
            }
            
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
            );
            
            pq.addAll(hm.entrySet());
            
            StringBuilder result = new StringBuilder();
            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
            }
            
            return result.toString();
    }

    // using array of characters and storing the count at the character index and looping thorjugh that to get the max count and print character/index at that time
    public String frequencySort2(String s) {
        int[] arr = new int[128];
        for(char ch : s.toCharArray()){
            arr[ch]++;
        }
        char[] ans = new char[s.length()];
        for(int i=0;i<s.length();){

            int max = 0;
            int index = 0;
            for(int j=0;j<128;j++){
                if(arr[j]>max){
                    max = arr[j];
                    index = j;
                }
            }
            
            while(arr[index] != 0){
                ans[i++] = (char)(index);
                arr[index]--;
            }
        }
        return new String(ans);
    }

}
