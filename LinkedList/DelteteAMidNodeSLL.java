package LinkedList;

public class DelteteAMidNodeSLL {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }


    // Brute force
    // By taking the length of the list and then placing the temp at the mid-1 index such that we can remove the index next to mid-1 i.e mid
    // point the mid-1 index to the mid+1 index and make mid as null and delete
    // TC : O(N)+O(N/2)
    public static void deleteMiddleNode(Node head){

        if(head==null || head.next==null) return;
        // find the length of list 
        int len = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        // get the mid 
        int mid = len/2;
        // now make temp to head and go till the mid-1 index
        temp = head;
        int i=1;
        while(i < mid){
            temp = temp.next;
            i++;
        }
        // point mid-1 index to the mid+1 index
        Node nextNode = temp.next;
        temp.next = nextNode.next;
        nextNode = null;

    }

    // optimal using 2 pointer (Haye-tortoise algo)
    // We are going from head slow and fast will move byu 1 and 2 steps resp.
    // why we took this 2 conditions 
    // 1 - fast.next.next != null (when we have even count of element in list so we have to read till the mid-1 index so we took this)
    // 1 2 3 4 [slow at 1,fast at 2] - we need to stop here only that's why we took this

    // 2.fast.next.next.next - (when we have odd count of element in list we have to read till mid-1)
    // 1 2 3 4 5 6 7 [slow-0,fast-0  slow-1,fast-2   slow-2,fast-4 ] - we ned to stop at index 2 of slow so that why we added that condition
    
    public static void deleteMiddleNode1(Node head){

        if(head == null || head.next!=null) return;
        Node slow = head;
        Node fast = head;

        while(fast.next.next!=null && fast.next.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node delNode = slow.next;
        slow.next = delNode.next;
        delNode = null;
    }

    // Instead of condition we can take the slow at head and fast at head.next.next 
    public static void deleteMiddleNode2(Node head){

        if(head == null || head.next!=null) return;
        Node slow = head;
        Node fast = head.next.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node delNode = slow.next;
        slow.next = delNode.next;
        delNode = null;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(2);
        Node third = new Node(30);
        Node fourth = new Node(4);
        Node fifth = new Node(11);
        Node six = new Node(11);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
     

        six.next = null;
        printList(head);
        
        deleteMiddleNode2(head);
        
        printList(head);
    }
}
