import java.util.ArrayList;
import java.util.Stack;

// Problem Statement: Given a circular integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner. If it doesn't exist, return -1 for this element.

// check in CIRCULAR ARRAY

public class NextGreaterElement_2 {
    
    // Naive
    // we can first outer loop o to n
    // then we check right side from i+1 to n and if its not thier 
    // then we check from 0 to i-1 and if its not thier then make as -1 otherwise some values we will get

    // TC : O(N*(M+X))= O(N*N) only
    

    //  Time complexity : O(N^2)
    // Space complexity : O(N) to store ans
    static void findNextGreaterElement2(int[] arr,int n){

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean found = false;

            for (int j = 1; j < n; j++) { 
                int index = (i+j)%n;
                if(arr[index] > arr[i]){
                    found = true;
                    ans.add(arr[index]);
                    break;
                }  
            }

            if(!found) ans.add(-1);
        }

        // OR
        /* 
            for(int i=0;i<n;i++){
              for(int j=i+1;j<i+n-1;j++){
                    ind = j % n;
                    if(arr[ind] > arr[i]){
                        ans.add(arr[ind]);
                        break;
                    }
                }
            } 
        */

        for(Integer x : ans){
            System.out.println(x);
        }
    }

    // Using Stack
    // Monotonic stack - stack in which elements are in specific order. either it is in increasing/Decreasing or other order.

    static void findNextGreaterElement2_Stack(int[] arr,int n){

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n*2-1;i>=0;i--){
            
            int ind = i%n;
            // pop all the element if they are less then current elemenet coz even we we make them stay in stack they are not able to see from front
            // suppose there are people standing of hegn 1 2 and if 4 cames before them this 1,2 heights peoples is not visible from front as the heighted 4 came before them so remove them its better

            while(!st.isEmpty() && st.peek() <= arr[ind]){
                st.pop();
            }
            
            if(i<n){ // add element to ans when we want to check for that element or when that element is under range of n 
                if(st.isEmpty()) 
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
            }
            st.push(arr[ind]);
        }

    }
    // or using 2 loops
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(arr,-1);
        
        for(int i=len*2-1;i>=0;i--){
            int index = i%len;
            while(!st.isEmpty() && nums[index] >= st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){          
                arr[index] = st.peek();
            }
            
            st.push(nums[index]);
        }
       
        return arr;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{18,4,7,12,8};

        findNextGreaterElement2(arr,arr.length);
    }
}
