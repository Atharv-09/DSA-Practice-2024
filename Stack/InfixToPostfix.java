import java.util.Stack;

public class InfixToPostfix {
    
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
    static void cal_InfixToPostfix(String s){

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                System.out.print(ch);
            }else if(ch == '('){ // if scanned char is '('
                st.push(ch);    
            }else if(ch == ')'){
                while(!st.isEmpty() && st.peek() !='('){ // until we reach to '(' we have to pop out all operators and add it to ans
                    System.out.print(st.pop());
                }
                st.pop();
            }else{ // if the scanned char is operator
                // if the curr operator is less precedence then the top then pop until the current pred is greater then top
                while(!st.isEmpty() && precedence(ch) <= precedence(st.peek())){
                    System.out.print(st.peek());
                    st.pop();
                }

                st.push(ch);
            }
        }
        // pop all oeprators from stack
        while (!st.isEmpty()) {
            if (st.peek() == '(')
                System.out.println( "Invalid Expression");
            System.out.print(st.pop());
        }
    }
    public static void main(String[] args) {
        
        String s = "a+b*(c^d-e)^(f+g*h)-i";

        cal_InfixToPostfix(s);
    }
}
