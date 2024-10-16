package LinkedList;
import java.util.*;
class Node{

    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
public class SLL_Reverse {
    public static void insertAtEnd(Node head,int data){

        Node dum = head;

        while(dum.next != null){
            dum = dum.next;
        }

        Node newNode = new Node(data);
        dum.next = newNode;
        newNode.next = null;
    } 
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    // Reverse a SLL
    // Brute Force : Using extra space (stack)
    // TC : O(N) SC : O(N)

    public static Node reverse_SLL(Node head){
        
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(!st.isEmpty()){
            temp.data = st.pop();
            temp = temp.next;
        }

        return head;
    }
    // Optimal solution by swapping the pointers
    // TC : O(N) SC :O(1)
    public static Node reverse_SLL1(Node head){

        Node prevNode = null;
        Node nextNode = null;
        Node temp = head;

        while( temp!=null ){
            // store the nextNode of the currNode in nextNode ref
            nextNode = temp.next;
            // instead of pointing temp to nextNode point to the prevNode
            temp.next = prevNode;
            // now move the prevNode to the currNode for the next iteration
            prevNode = temp;
            // and move temp as the nextNode for the next iteration
            temp = nextNode;
        }

        return prevNode;
    }

    // RECURSIVE : 

    public static Node reverse_SLL_Recursive(Node head){

        if(head== null || head.next == null) return head;

        // reverse the linked list starting from the second node
        Node newHead = reverse_SLL_Recursive(head.next);

        // save the refernce to node following the currrent head node
        Node front = head.next;

        // make the from node point to the curr "head" node in reverseed order
        front.next = head;
        // Break the link from the current 'head' node to the front node to avoid the cycle
        head.next = null;

        return newHead;

    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(19);

        insertAtEnd(head,1);
        insertAtEnd(head,12);
        insertAtEnd(head,6);
        insertAtEnd(head,11);
        
        printList(head);

        // head = reverse_SLL(head);
        head = reverse_SLL_Recursive(head);
        printList(head);

    }
}
