package Strings;
/*Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

1. s = "egg", t = "add" true [e-a,g-d]
2. s = "foo", t = "bar" false [f-b,o-a, but o can't again map to r as already mapped to a]
3. s = "paper", t = "title" true
*/
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        
        int[] map1  = new int[200];
        int[] map2  = new int[200];
        
        if(s.length()  != t.length())  return false;

        for(int i=0;i<s.length();i++){

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // string s ="tob" string t = "bux"
            // t - 1 , b -1 ..... o - 2 , u - 2 ....... as for b - 1 (as it was aleready mapped) and x - 0 
            // both are not same return false
            if(map1[c1] != map2[c2]) return false;
            // we will map them and make that character index value as the same(current character index+!)
            map1[c1] = i+1;
            map2[c2] = i+1;
        } 

        return true;
    }
}
