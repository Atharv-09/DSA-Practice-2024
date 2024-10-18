package LinkedList;

public class RemoveDuplicatesFromSortedDLL {
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
        
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head = insertAtEnd(head,2);
        head = insertAtEnd(head,2);
        head = insertAtEnd(head,2);
        head = insertAtEnd(head,6);
        head = insertAtEnd(head,9);
        
    
        printList(head);

        head = removeDuplicatesFromSortedDLL1(head);
        printList(head);
    }
    private static Node removeDuplicatesFromSortedDLL(Node head) {
        
        if(head == null || head.next==null) return head;
        Node temp = head.next; // we will start from the next node of head
        Node prevNode = head; // we have pointer to the prev non repeating values

        int prevVal = head.data; // we will store the prevval as if we encounter the node with same value we will just skip that node

        while(temp!=null){
            // if we are at the last node 
            if(temp.next == null){
                prevNode.next = null;
            }
            if(temp.data == prevVal){
                temp = temp.next;
            }else{
                prevNode.next = temp;
                temp.prev = prevNode;
                prevNode = temp;
                prevVal = temp.data;
                temp = temp.next;
            }
            
        }

        return head;
    }
    // Approach 2   
    private static Node removeDuplicatesFromSortedDLL1(Node head) {
        
        if(head == null || head.next==null) return head;
        
        Node temp = head;
        Node nexNode = null;
        while(temp!=null){

            nexNode = temp.next;
            while(nexNode!=null && nexNode.data == temp.data){
                // we are skippingi the repeated values / duplicate values
                nexNode = nexNode.next;
            }
            temp.next = nexNode;
            if(nexNode!=null) nexNode.prev = temp;

            temp = temp.next;
        }
        
        
        return head;
    }
}
