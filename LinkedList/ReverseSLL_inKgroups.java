package LinkedList;

public class ReverseSLL_inKgroups {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node six = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;
        printList(head);

        head = reverseLLinKGroup(head,3);
        printList(head);
    }

    private static Node reverseSLL(Node temp){

        Node prev = null;
        Node curr = temp;
        Node next = null;

        while(curr!=null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node getKthNode(Node temp,int k){
        int i =1;
        while(temp!=null && i<k){
            temp =temp.next;
            i++;
        }
        return temp;
    }
    private static Node reverseLLinKGroup(Node head, int k) {
        Node temp = head;
        Node prevLast = null;

        while(temp!=null){
            
            Node kthNode = getKthNode(temp, k);
            // kthnode is null means not a complete group
            if(kthNode == null){
                // if thiere was a prev group point the prevLast to the current temp
                // prevLast points to the last element of thr group
                if(prevLast!=null)
                    prevLast.next = temp;
                break;
            }
            
            Node nextNode = kthNode.next;// store the pointer of the next node after kth node for the next group
            kthNode.next = null; //disconnect the kth node
            
            Node newHead = reverseSLL(temp);

            // adjusting the head if the reversal start from head
            if(temp == head){
                head = newHead;
            }else{
                // make the link between the prev group and this currently reversed group
                prevLast.next = newHead;
            }

            prevLast= temp;
            temp = nextNode;
        }

        return head;
    }

    // ANOTHER SHORT APPROACH : 

    public Node reverseKGroup(Node head, int k) {
        
        Node temp = head; // it will move the pointer one by one
        Node start = head; // it will always points to the start of the k group elements
        
        Node dum = new Node(-1); // 
        Node lastN = dum; // it will always points to the last of the prev k groups elements
        // such that this last next will point to the first/reverse set of next k group elements

        int val = 1;
        while(temp!=null){
            Node nextN = temp.next; // stores next pointer as we are making temp.next null as to delink from LL and find the revers of k group of eleents
            if(val%k == 0){ // 4 - 5 - 6 - 7 - 8  k=2
               temp.next = null; // de link the k group from the LL such that we can reverse // 4 -> 5 -> NULL (here 5 is the start)
               Node first = reverseSLL(start); //  5 -> 4 (here first is 5 which is returned by reverse algo) and we pass the start eleent of the k group
                lastN.next = first; // now this lastN means last element of k previos k group will point to this current k group reversed eleents
            // 1 loop lastN -> dummy so last1 -> will point to that first(5)
                lastN = start; // now the lastN will become new last of this k group element lasti.e first(4)
                start = nextN; // and the start will e next k group start
            }

            temp = nextN;
            val++;
        }
        if(start!=null) lastN.next = start;

        return dum.next;
    }
}
