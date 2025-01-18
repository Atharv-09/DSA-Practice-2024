package LinkedList;

class Node{

    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
public class SLL_Insert {

    static Node head;

    public static void insertAtbeg(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAfterGivenNode(int val,int data){

        Node node = head;
        while(node!=null){
            if(node.data == val)
                break;
            node = node.next;
        }


        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    
    }
    public static void insertBeforeGivenNode(int val,int data){

        if(head==null){
            return;
        }

        if(head.data == val){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = null,curr = head;

        while(curr != null){
            if(curr.data == val){
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        Node newNode = new Node(data);
        newNode.next = curr;
        prev.next = newNode;


    }
    public static void insertAtEnd(int data){

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
    public static void main(String[] args) {
        
        head = new Node(10);
        head.next = new Node(19);

        insertAtbeg(128); // 128 10 19 
        insertAfterGivenNode(10,11); // 128 10 11 19
        insertBeforeGivenNode(11,90); // 128 10 90 11 19
        insertAtEnd(1);
        printList(head);
    }
}
