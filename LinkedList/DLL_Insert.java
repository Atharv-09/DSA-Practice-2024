package LinkedList;



public class DLL_Insert {
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

    public static Node insertAtBeg(Node head,int data){

        Node newNode = new Node(data);
        newNode.next = head;
        if(head!=null)
            head.prev = newNode;
        

        return newNode;
    }
    public static Node insertAfter(Node head,int key,int data){

        Node dum = head;
        while(dum != null){
            if(key == dum.data) break;
            dum = dum.next;
        }

        if(dum == null) return head;

        Node newNode = new Node(data);
        
        newNode.next = dum.next;     
        newNode.prev = dum;                                               
        if(dum.next != null)
            dum.next.prev = newNode;

        dum.next = newNode;
        
        return head;
    }

    public static Node insertBefore(Node head,int key,int data){

        Node temp = head;

        while(temp != null){
            if(temp.data == key) break;
            temp = temp.next;
        }

        if(temp == null) return null; //curr key not found

        Node newNode = new Node(data);
        // set the newNode next to the tempNode
        newNode.next = temp;
        //Set prev of new node to prev of given node
        newNode.prev = temp.prev;

        // Update next of given node's prev to new node
        if(temp.prev!=null)
            temp.prev.next = newNode;
        else 
            head = newNode; // if the current node is headNode make newNode as head

        temp.prev = newNode;

        return head;
    }

    public static Node insertAtEnd(Node head,int data){

        Node newNode = new Node(data);

        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;

        return head;
    }
    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.prev = head;
        head.next.next = new Node(19);
        head.next.next.prev = head.next;

        printList(head);
        head = insertAtBeg(head,8);
        printList(head);
        head = insertAfter(head,19,20);
        printList(head);
        head = insertBefore(head,10,5);
        printList(head);
        head = insertAtEnd(head,100);
        printList(head);


    }
}
