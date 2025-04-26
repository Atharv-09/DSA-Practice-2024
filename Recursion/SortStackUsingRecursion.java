package Recursion.A2ZSheet;

import java.util.Stack;

public class SortStackUsingRecursion {

    void insertAtBottom(Stack<Integer> stack, int ele){
        if(stack.isEmpty() || stack.peek()<ele){
            stack.push(ele);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack,ele);
        stack.push(top);

    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        Stack<Integer> stack = new Stack<>();

        while(!s.isEmpty()){
            int top = s.pop();
            if(stack.isEmpty() || stack.peek() <= top){
                stack.push(top);
            }else{
                insertAtBottom(stack,top);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(3);
        Stack<Integer> sort = new SortStackUsingRecursion().sort(st);

    }
}
