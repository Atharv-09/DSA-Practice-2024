package LinkedList;

class Node{

    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

public class MiddleNodeOfSLL {
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

    // TC : O(N);
    public static Node middleNode(Node head) {

        int totalNode = 0;
        Node temp = head;
        while(temp != null){
            totalNode++;
            temp = temp.next;
        }
        int mid = totalNode/2;
        temp = head;
        int count =0;
        while(temp!=null){
            if(count == mid) return temp;
            temp = temp.next;
            count++;
        }

        return null;
    }

    public static Node middleNode1(Node head) {

        Node slow = head;
        Node fast = head;

        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(19);

        insertAtEnd(head,1);
        insertAtEnd(head,12);
        insertAtEnd(head,6);
        insertAtEnd(head,11);
        
        printList(head);

        Node mid = middleNode1(head);
        System.out.println(mid.data);
    }
}
