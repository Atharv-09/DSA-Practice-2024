package LinkedList;

public class RotateSLLByKpos {
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
        Node six = new Node(6);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;
        printList(head);

        head = rotateSLLByK1(head,3);
        printList(head);
    }

    // TC : O(K*N)
    // SC : O(1)
    //For each k, find the last element from the list. Move it to the first.

    private static Node rotateSLLByK(Node head, int k) {
        
        if(head==null || head.next==null) return head;

        for(int i=0;i<k;i++){
            Node last = head;
            Node prevOfLast = null;
            // take the last element and its previous
            while(last.next!=null){
                prevOfLast = last;
                last = last.next;
            }
            // make the last prev point to the null it will becond the tail
            prevOfLast.next=null;
            last.next = head; // make the last next as head 
            head = last;// make last as new head

        }

        return head;
    }

    // as if thier are many k we have to do the above for that
    // But if the k>len of list then instead of rotating k times we have to rotate = k%len times

    // Instead of traversing 
    // OPTIMAL : make the list as circular list and then cut down the part to get the start and end of the list
    // TC : O(N)
    private static Node rotateSLLByK1(Node head, int k) {

        Node temp = head;
        int len = 1;
        while(temp.next!=null){
            len++;
            temp = temp.next;
        }

        // making circular list
        temp.next = head;

        k = k%len; // as we knw if k>len then istead of rotating the list k time make thier module to get k
        int end = len-k; // as we know we we have to rotate k= 3 {1-2-3-4-5} the last three element comes first so thier is cutoff from the 2nd node
        // maded 5-3 = 2 (2nd node is the cutoff node)
        while(end != 0){
            temp = temp.next;
            end--;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}
