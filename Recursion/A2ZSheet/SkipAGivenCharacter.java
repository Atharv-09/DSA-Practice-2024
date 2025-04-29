package Recursion.A2ZSheet;

public class SkipAGivenCharacter {

    static void helper(String s,char ch,String ans){

        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }

        if(s.charAt(0) != ch) ans += s.charAt(0);
        helper(s.substring(1),ch,ans);
    }

    // if we want to skip the string
    // s = "bananaapple" str = banana ans = apple
    static void helper2(String s,String str,String ans){

        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        if(s.startsWith(str)){
            helper2(s.substring(str.length()),str,ans);
        }
        else {
            helper2(s.substring(1),str,ans+s.charAt(0));
        }
    }


    public static void main(String[] args) {

        helper("bacaafasadaafasfaaacad",'a',"");
        helper2("bananaapplemango","apple","");
    }
}
