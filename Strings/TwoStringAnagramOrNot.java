package Strings;

public class TwoStringAnagramOrNot {
    public static boolean isAnagram(String s, String t) {
        
        // brute sort the string and check each character
        // optimal is by using hashtale
        // increase the char count for the s string and decrease the char count for character in t string
        // as if they are of equal no all becomes cut out , so if any of the char remains in freq array that measn its not an anagram

        //HASHIN URING ARRAY
        int freq[] = new int[26];

        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
    
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)-'a']--;
    

        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;

        /*HASHING USING HASH MAP
         * Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
         */
    }

    public static void main(String[] args) {
        
        System.out.println(isAnagram("potato","lotus"));
    }
}
