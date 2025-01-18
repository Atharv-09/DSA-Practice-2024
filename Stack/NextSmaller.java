/*Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * 
 * Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
*/

//NEXT SMALLER ON THE LEFT SIDE OF THE ELEMENT 



import java.util.Stack;

public class NextSmaller {
    // using brute force we can gget

    // using Monotonic stack
    // tc : O(2n)

      public static int[] prevSmaller(int[] A) {
        
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && st.peek() >= A[i])
                st.pop();
            
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(A[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[] ans = prevSmaller(new int[]{4,5,2,10,8});
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }
}
