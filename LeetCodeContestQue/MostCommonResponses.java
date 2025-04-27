package LeetCodeContestQue;

import java.util.*;
/*3527. Find the Most Common Response
Solved
Medium
Companies
Hint
You are given a 2D string array responses where each responses[i] is an array of strings representing survey responses from the ith day.

Return the most common response across all days after removing duplicate responses within each responses[i]. If there is a tie, return the lexicographically smallest response.

A string a is lexicographically smaller than a string b if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
If the first min(a.length, b.length) characters do not differ, then the shorter string is the lexicographically smaller one.


Example 1:

Input: responses = [["good","ok","good","ok"],["ok","bad","good","ok","ok"],["good"],["bad"]]

Output: "good"

Explanation:

After removing duplicates within each list, responses = [["good", "ok"], ["ok", "bad", "good"], ["good"], ["bad"]].
"good" appears 3 times, "ok" appears 2 times, and "bad" appears 2 times.
Return "good" because it has the highest frequency.
Example 2:

Input: responses = [["good","ok","good"],["ok","bad"],["bad","notsure"],["great","good"]]

Output: "bad"

Explanation:

After removing duplicates within each list we have responses = [["good", "ok"], ["ok", "bad"], ["bad", "notsure"], ["great", "good"]].
"bad", "good", and "ok" each occur 2 times.
The output is "bad" because it is the lexicographically smallest amongst the words with the highest frequency.*/
public class MostCommonResponses {
    public String findCommonResponse(List<List<String>> responses) {

        Map<String,Integer> map = new HashMap<>();

        for(List<String> res: responses){
            Set<String> set = new HashSet<>(res);

            for(String r: set){
                map.put(r,map.getOrDefault(r,0)+1);
            }
        }

        String mostCommon = "";
        int maxCount = 0;

        // Go through the map and pick the most common one
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String response = entry.getKey();
            int count = entry.getValue();

            // If higher frequency or lexicographically smaller, update the answer
            if (count > maxCount || (count == maxCount && response.compareTo(mostCommon) < 0)) {
                mostCommon = response;
                maxCount = count;
            }
        }
        return mostCommon;
    }

    public static void main(String[] args) {
        List<List<String>> responses = new ArrayList<>();

        // Adding sample data
        responses.add(Arrays.asList("good", "ok", "good", "ok"));
        responses.add(Arrays.asList("ok", "bad", "good", "ok", "ok"));
        responses.add(Arrays.asList("good"));
        responses.add(Arrays.asList("bad"));
        String ans = new MostCommonResponses().findCommonResponse(responses);
        System.out.println(ans);
    }
}
