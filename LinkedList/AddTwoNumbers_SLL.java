package LinkedList;

public class AddTwoNumbers_SLL {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(2);
        Node second = new Node(9);
        Node third = new Node(9);
        Node fourth = new Node(9);
        Node fifth = new Node(9);
        Node six = new Node(9);

        head1.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;

        Node head2 = new Node(2);
        Node second2 = new Node(9);
        Node third2 = new Node(9);
        Node fourth2 = new Node(9);
        Node fifth2 = new Node(9);
        Node six2 = new Node(9);

        head2.next = second2;
        second2.next = third2;
        third2.next = fourth2;
        fourth2.next = fifth2;
        fifth2.next = six2;
        six2.next = null;
        printList(head1);
        printList(head2);
        
        Node newHead = addTwoList(head1,head2);
        
        printList(newHead);
    }
    private static Node addTwoList(Node head1, Node head2) {
        
        if(head1 == null && head2==null) return null;
        Node temp1=head1,temp2=head2;
        Node dum = new Node(-1);
        Node temp = dum;
        int carry = 0;

        while(temp1!=null || temp2!=null || carry==1){
            int sum = 0;
            if(temp1!=null){
                sum += temp1.data;
                temp1 = temp1.next;
            }

            if(temp2!=null){
                sum += temp2.data;
                temp2 = temp2.next;
            }

            // add carry
            sum += carry;
            carry = sum/10 ; // if greater then 10 then w=thier is one carry

            Node newNode = new Node(sum%10);
            temp.next  = newNode;
            temp = temp.next;
        }
        return dum.next;
        
    }
    private static Node reverseList(Node head1) {
        
        Node prevNode = null;
        Node curr = head1;
        Node nextNode = null;

        while(curr!=null){
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr; // make the curr node as prev
            curr = nextNode; // move current
        }
        return prevNode;
    }
}
