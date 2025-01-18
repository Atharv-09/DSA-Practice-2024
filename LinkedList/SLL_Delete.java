package LinkedList;
class Node{

    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
public class SLL_Delete {
    
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node deleteAtBeg(Node head){

        if(head == null) return null;
        if(head.next == null) return null;

        Node temp = head;
        head = head.next;
        
        temp = null;
        return head;
    }

    public static Node deleteAtSpecificPos(Node head,int pos){

        Node temp = head;
        if(pos == 1){
            head = temp.next;
            return head;
        }
        int count = 1;
        Node prev = null;
        while(temp != null){
            if(count == pos) break;
            prev = temp;
            temp = temp.next;
            count++;
        }

        prev.next = temp.next;
        return head;

    }
    private static Node deleteTail(Node head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null)
            return null;
        // Create a temporary pointer for traversal
        Node temp = head;
        // Traverse the list until the second-to-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // Nullify the connection from the second-to-last node to delete the last node
        temp.next = null;
        // Return the updated head of the linked list
        return head;
    }
    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(19);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(15);
        printList(head);
        head = deleteAtBeg(head);
        head = deleteAtSpecificPos(head, 3);
        head = deleteTail(head);
        printList(head);
    }
}
