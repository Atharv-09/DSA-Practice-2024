import java.util.*;
class Main {
    // Recursive
    void helper(Node root, List<Integer> ans){
        if(root == null) return;
        
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);

        return ans;
    }

    // iterative

    public void preOrderIterative(Node root){
        if(root==null) return;
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> ans = new ArrayList<>();

        while(!st.isEmpty()){
            Node topEle = st.pop();
            ans.add(topEle.val);
            
            if(topEle.right!=null) st.push(topEle.right);
            if(topEle.left!=null) st.push(topEle.left);
        }
    }
}