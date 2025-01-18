package LinkedList;

public class DeleteAllOccurence_DLL{
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

    // Brute force
    // I can think that we can take arraylist and store the element that is not equal to k and aagain traverse and keep the araray list
    // element return to the DLL and after end just make it null
    // TC : O(N) SC : O(N)

    // Optimal 
    // TC : O(N) SC : O(1)
    static Node deleteOccurence(Node head,int k){

        if(head == null || (head.next==null && head.data==k)) return null;
        Node preNode = null;
        Node nextNode = null;
        
        
        Node temp = head;
        while(temp!=null){
            if(temp.data == k){
                // If the k element occurs at the start of list just ignore the elements
                if(temp == head)
                    head=  head.next;

                preNode = temp.prev; // mark the prevNode
                nextNode = temp.next; // mark the nextNode of temp
                
                if(preNode!=null)  // if prevNode is thiere ppoint that next to temp.next i.e nextNode
                    preNode.next = nextNode; 
                if(nextNode!=null)  // if the nextNode is thier point thier prev to the prevNode.
                    nextNode.prev = preNode;
                
                temp = nextNode;

            }else{
                temp = temp.next;
            }
            
        }
        return head;
    }
    // GOOD SHORT APPROACH
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        
        while(head!=null && head.data == x){
            head = head.next;
        }
        if(head == null || head.next == null) return head;
        
        Node temp = head;
        while(temp!=null){
            Node prevN = temp.prev;
            Node nextN = temp.next;
            if(temp.data == x){
                if(temp.prev!=null){
                    temp.prev.next = nextN;
                }
                if(temp.next!=null){
                    temp.next.prev = prevN;
                }
            }
            temp = nextN;
        }
        return head;
    }
    public static void main(String[] args) {
        
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(10);
        head.next.next.prev = head.next;

        head = insertAtEnd(head,8);
        head = insertAtEnd(head,4);
        head = insertAtEnd(head,2);
        head = insertAtEnd(head,5);
        head = insertAtEnd(head,2);
        
        printList(head);

        head = deleteOccurence(head,2);

        printList(head);
    }
}