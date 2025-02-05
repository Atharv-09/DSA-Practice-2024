import java.util.*;
class Pair{

    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }    
}

// TC : O(1)
// SC :  O(2xn) coz we are storing a pair of DS

// here simply we will store the pair in stack having element and the min element till now
// so whenever they need min element we can simply return the min element of the top


public class MinStack {

    
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if(st.isEmpty()) // if the stack is empty then the current eleent is the min element till now
            min = val;
        else
            min = Math.min(st.peek().y,val); // get the last min and the current element as min for the current element
        
        st.push(new Pair(val,min));
    }

    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}

class MinStack1 {

    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    public MinStack1() {
        st = new Stack<>();
    }
    public void push(int val) {

        if(st.isEmpty()){
            min = val;
            st.push(val);
        }else{
            if(val < min){ // curr val to push less then the min 
                // then we will put the new val to the stack using formul = 2 * val - lastMin
                // and at this condition the top is the min only
                st.push(2*val-min);
                min = val;
            }else{
                st.push(val);
            }
        }
    }
    public void pop() {

        if(st.isEmpty()) return;

        int x = st.peek();
        st.pop();
        if(x < min){ // then it means its the modified value
            min = 2*min - x; // 2 * prevMin - newValue which we added before (2*10 - 8 = 12 is the prev min)
        }
    }
    
    public int top() {

        if(st.isEmpty()) return -1;

        int x = st.peek();
        if(x < min){ // means we have modified the value and putted it stack at that time the min value is the top element value
            // -4 < -3 or 8 < 10
            return min;
        }
        return x;
    }
    
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        
        MinStack1 ms1 = new MinStack1();

        ms1.push(12);
        ms1.push(15);
        ms1.push(10);
        System.out.println(ms1.getMin()); // 10 
        ms1.pop();
        System.out.println(ms1.getMin()); // 12 
        System.out.println(ms1.top()); // 15 
        ms1.push(10);
        System.out.println(ms1.top());
    }
}

// Using 2 stacks
public class MinStack {

    Stack<Integer> stack, min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty()) min.push(x);
        else if (min.peek() >= x) min.push(x);
    }

    public void pop() {
        int popped = stack.pop();
        if (!min.empty() && min.peek() == popped) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}        


// Optimize
// as we are using the pairs so optimize it
// we will take a variable min and put 

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

