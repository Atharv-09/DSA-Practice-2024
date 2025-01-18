package LinkedList;
//237. Delete Node in a Linked List

/*There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head. */
public class SLL_DeleteNode {
    
    static class Node{

        int data;
        Node next;
        public Node(int data){
            this.data = data;
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

    public static void deleteNode(Node node){

        if(node!=null && node.next!=null){
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }
    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(19);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(15);
        printList(head);
        deleteNode(head.next.next);
        printList(head);
    }
}
