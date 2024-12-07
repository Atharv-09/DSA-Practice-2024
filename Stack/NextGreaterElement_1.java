
//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

import java.util.Stack;

public class NextGreaterElement_1 {

    // Using 2 looops we can check the next greater eleemnt 
    // for every element travers the array from index+1 to the n and check is thier is greater then the ith element then add as NGE
    // TC : O(N^2) , SC : O(N)

    // Using stack
    static void findNextGreaterElement1(int[] arr,int n){
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i=n-1;i>=0;i--){
            // removing the element from stack if the top element is less then the current element
            while(!st.isEmpty() && st.peek() <= arr[i])
                    st.pop();
            
            if(st.isEmpty()) { 
                // stack if empty when thier is no greater element to the right
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,1,7,6,0};
        findNextGreaterElement1(arr,arr.length);
    }
}
