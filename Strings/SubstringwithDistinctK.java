package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class SubstringwithDistinctK {
    static void findCount(String s,int n,int k){

        int count = 0;
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                // String suString = s.substring(i,j);
                set.add(s.charAt(j));
                if(set.size() == k) count++;
            }
        }

        System.out.println(count);
    }


    // best 
    // using slidnig window
    /*The idea is to use two sliding windows.

1) 1st sliding window will keep track of substrings with atmost 'k' distinct characters.

2) 2nd sliding window will keep track of substrings with atmost 'k-1' distinct characters.

The difference between these counts gives the count of substrings with exactly 'k' distinct characters.*/

// why we are doing k and k-1 1

/*suppose we have abaaca string
 * 
 * aba string then
 * for k = 2 
 * for l = 0 , r=0 map = a - 1
 * ans = ans + 1
 * for l = 0 , r = 1 map - a - 1 and b - 1
 * ans = ans + (1-0+1) = 1 + 2 = 3
 * for l = 0, r = 2 map = a - 2 and  b - 1
 * ans = ans + (2-0+1) = 3 + 3 = 6
 * 
 * BUT WE HAVE ONLY 3 SUBSTRING WITH 2 DISTINE=T I.E (ab,ba,aba) how we get 6 here so while adding h-l+1 we are considering the single vvalues also like a,b,a so thats why we have to calculate k-1
 * 
 * for k-1 i.e k=1 we will get ans = 3 
 * so we subsrttact k to k- 1 = 6 - 3 === final ans = 3 i.e correct
 */
    static int countSubstr(String s, int n,int k) {
        return findCount1(s,n,k)-findCount1(s,n,k-1);
    }

    static int findCount1(String s,int n,int k){

       HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int l = 0,r=0;

       while(r < n){
            char ch = s.charAt(r);

            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(map.size()>k){
                char leftP = s.charAt(l);
                map.put(leftP,map.getOrDefault(leftP,0)-1);
                if(map.get(leftP) == 0) map.remove(leftP);
                l++;
            }
            
           count += (r-l+1);
            r++;
       }
       return (count);
    }
    public static void main(String[] args) {
        
        String s = "abaaca";
       System.out.println(countSubstr(s,s.length(),2));
    }
}
