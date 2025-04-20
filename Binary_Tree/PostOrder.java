import java.util.*;
public class PostOrder {

    // using 1 stack
    public List<Integer> postorderTraversal3(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node temp = root;

        if(root == null) return ans;

        st.push(root);
        while(!st.isEmpty()){
            Node topE = st.pop();
            ans.addFirst(topE.val);

            if(topE.left!=null) st.push(topE.left);
            if(topE.right!=null) st.push(topE.right);
        }
        return ans;
    }
    // OR ABOVE AND BELOW ARE SMAE JUST HERE RETURNTYPE IS ARRAYLIST so thier is no method addFirst() in that
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(node);
        while(!s.isEmpty()){
            Node x = s.pop();
            if(x.left!=null) s.push(x.left);
            if(x.right!=null) s.push(x.right);
            ans.add(x.val);
        }
        Collections.reverse(ans);
        return ans;
    }


    /// USING ! STACk (GOOD APPROACH)
    ArrayList<Integer> postOrder4(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        
        Node curr = node;

        while(curr!= null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }else{
                Node topE = st.peek();
                Node temp = topE.right;
                
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.data);
                    Node newTop = st.peek();
                    while(!st.isEmpty() && newTop.right == temp){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return ans;
    }


    // Using 2 stack
    // TC : O(2N) SC : O(2N)
    public List<Integer> postorderTraversal2(Node root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty()){
            Node topEle = st1.pop();
            st2.push(topEle);
            if(topEle.left!=null) st1.push(topEle.left);
            if(topEle.right!=null) st1.push(topEle.right);
        }

        while(!st2.isEmpty()){
            int val = st2.pop().val;
            ans.add(val);
        }
        return ans;
    }

    // recursion
    // TIME : O(N) SPACE : O(N)
    void helper(Node root, List<Integer> ans){

        if(root == null) return;
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(Node root) {
        
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}