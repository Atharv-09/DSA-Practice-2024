package Recursion.A2ZSheet;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    static void insertAtBottom(Stack<Integer> s, int ele){

        if(s.isEmpty()){
            s.push(ele);
            return;
        }

        int top = s.pop();
        insertAtBottom(s,ele);
        s.push(top);
    }
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.isEmpty()) return;

        int ele = s.pop();
        reverse(s);
        insertAtBottom(s,ele);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(23);
        st.push(10);
        ReverseStackUsingRecursion.reverse(st);

        st.forEach(System.out::println);
    }
}
