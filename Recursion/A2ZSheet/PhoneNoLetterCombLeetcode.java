package Recursion.A2ZSheet;

import java.util.ArrayList;
import java.util.HashMap;

// we given a phone number such that
// 2 = abc, 3 = def ... 7 = pqrs

/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.*/
//digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

public class PhoneNoLetterCombLeetcode {

    // By generating start and end for each digit
    static ArrayList<String> helper(String un, String p){

        if(un.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        ArrayList<String> curr = new ArrayList<>();

        int dig = un.charAt(0)-'0'; // char to int
        // if dig = 2 (accoding to prev range is) start = (dig-1)*2 = 1*3 = 3 to 6
        // but now abc starts with 2 not with 1 in keypad
        // start = (dig-2)*3 = (2-2)*3 = 0 to end = start + 3 = 3
        // for 2 => start 0 and end 3(exclusive)

        // if dig is greater then 7 start +1 as at 7 thier are 4 digits
        // but if the keypad dig is 7 or 9 end it +1

        int start = (dig-2)*3;
        if(dig > 7) start+=1;
        int end = start+3;
        if(dig == 7 || dig == 9) end+=1 ;

        for(int i=start;i<end;i++){

            char ch = (char)('a'+i);
            ArrayList<String> prevCall = helper(un.substring(1),p+ch);
            curr.addAll(prevCall);
        }
        return curr;
    }

    // Optimised
    // By already keeping that values in the map
    static void phoneComb(String un) {

        ArrayList<String> arr = new ArrayList<>();
        HashMap<Character,String> letter= new HashMap<>();
        letter.put('2',"abc");
        letter.put('3',"def");
        letter.put('4',"ghi");
        letter.put('5',"jkl");
        letter.put('6',"mno");
        letter.put('7',"pqrs");
        letter.put('8',"tuv");
        letter.put('9',"wxyz");

        combinationHelper(un,new StringBuilder(),0,arr,letter);
        System.out.println(arr);
    }

    static void combinationHelper(String un, StringBuilder sb, int ind, ArrayList<String> arr, HashMap<Character,String> digits){

        if(sb.length() == un.length()){
            arr.add(sb.toString());
            return;
        }

        for(Character ch : digits.get(un.charAt(ind)).toCharArray()){
            sb.append(ch);
            combinationHelper(un,sb,ind+1,arr,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

        String input = "78";
        ArrayList<String> ans = helper(input,"");
        System.out.println(ans);

        // other solution
        phoneComb(input);
    }
}
