import java.util.Stack;

import BS.SqrRootOfN;

public class InfixToPrefix {
    static int precedence(char ch){

        switch (ch) {
            case '+':
            case '-':
                    return 1;
            case '*':
            case '/':
                    return 2;
            case '^':
                    return 3;
        }
        return -1;
    }
    static String reverse(String s){

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return sb.toString();
    }

    static String makeParenthesisReverse(String rev){
        StringBuilder sb = new StringBuilder(rev);
        for(int i=0;i<rev.length();i++){
            char ch = rev.charAt(i);
            if(ch == '(') sb.setCharAt(i, ')');
            if(ch == ')') sb.setCharAt(i, '(');
        }
        return sb.toString();
    }
    static void cal_InfixToPrefix(String s){

        Stack<Character> st = new Stack<>();
        String ans = "";

        String rev = reverse(s); // revesing the string
        
        // after reversing make ( as ) and ) as (        
        rev = makeParenthesisReverse(rev);

        // infix to postfix type of conversion
        for(int i=0;i<rev.length();i++){

            char ch = rev.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                ans += ch;
            }else if(ch =='(') st.push(ch);
            else if(ch == ')'){
                // pop out all element till we encounter (
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            }else{
                //its operator

                if(ch == '^'){ // not allow same priority element in the stack or if - and stack peek * then we will pop out
                    while(!st.isEmpty() && precedence(ch) <= precedence(st.peek())){
                        ans += st.pop();
                    }
                }else{

                    while(!st.isEmpty() && precedence(ch) < precedence(st.peek())){
                        ans += st.pop();
                    }
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }

        // reverse
        System.out.println(reverse(ans));

    }
    public static void main(String[] args) {
        
        String s = "(p+q)*(c-d)";

        cal_InfixToPrefix(s);
    }
}
