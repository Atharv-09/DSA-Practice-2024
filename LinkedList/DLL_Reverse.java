package LinkedList;
import java.util.*;
public class DLL_Reverse {
    static class Node{

        int data;
        Node prev;
        Node next;
    
        public Node(int data){
            this.data = data;
            next=prev=null;
        }
    }
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }


    // Brute force 
    // By using stack (As we know that LL store only data so we will put the data in stack and then replace from top to bottom)
    // TC : O(N) SC : O(N)
    public static Node reverseDLLUsingStack(Node head){

        Stack<Integer> st = new Stack<>();

        Node temp = head;
        while(temp != null){
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
    // OPtimal
    // Just swapping the pointers 
    // TC : O(N) SC :O(1)
    public static Node reverseDLL(Node head){

        if(head == null || head.next == null) return null;

        Node curr = head;
        Node last = null;
        
        while (curr!=null) { // actually we are doing swapping of the pointers
            last = curr.prev;
            // we will swap the next pointer with the prev pointer of curr
            curr.prev = curr.next;
            // current next will become curr prev
            curr.next = last;
            curr = curr.prev; // as we swapped the next and prev we have to go prev way
        }
        return last.prev; // as we are at the last 2 index from head the last.prev will new head
    }

    // we can swap by taking front and back pointer of node
    // we can do curr.next = back and curr.prev = front;
    // BUt it will take 2 extra pointers
    // Instead swap
    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.prev = head;
        head.next.next = new Node(19);
        head.next.next.prev = head.next;
        printList(head);

        head = reverseDLLUsingStack(head);
        
        printList(head);
    }
}
