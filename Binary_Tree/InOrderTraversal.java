import java.util.*;

class InOrderTraversal{

    public void preOrderIterative(Node root){
        if(root==null) return;
        
        Stack<Node> st = new Stack<>();
        Node temp = root;

        while(true){
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }else{
                if(st.isEmpty()) break;
                temp = st.pop();
                System.out.print(temp.val+" ");
                temp = temp.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right=new Node(50);

        new InOrderTraversal().preOrderIterative(root);
    }

}