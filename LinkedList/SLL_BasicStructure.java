package LinkedList;

public class SLL_BasicStructure {
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

    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(19);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(15);
        printList(head);
        printList(head);
    }
}
