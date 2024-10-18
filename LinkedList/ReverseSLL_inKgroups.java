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
}
