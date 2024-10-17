package LinkedList;

public class RemoveNthNodeFromLast {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    // Brute force
    // TC : O(L) to take count + O(L-k) to reach till the k-1 the element 
    // SC : O(1)
    //The brute force, in the worst case, has a time complexity of O(2*L) 
    public static Node removeKthNodeFromLast(Node head,int k){
        
        //1. calculae the length of the LL
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        // if the node to delete is the first node
        if(k==len) {// delete head from ll
            Node newHead = head.next;
            head = null;
            return newHead;
        }

        temp = head;
        int preNodeC = len-k; // to get the pre Node count of the deletion node
        int index = 1 ;

        while (temp!=null) {
            if(index == preNodeC){
                Node nextNode = temp.next;
                temp.next = nextNode.next;
                nextNode=null;
                return head;
            }
            temp = temp.next;
            index++;
        }
        return null;
    }

    // Optimal Approac
    // TWO POINTERS APPROACJ
    //1. we will take 2 pointers such that slow and fast, 1st time fast will move to the kth index from slow
    // and from next they will move one by one as the fast reached at the end of list the slow will definitely at L-Nth index

    // 1. move th fast pointer at the k distance from the slow, if we do this thier is gap of k dist so when the next pointer reaches end the slow pointer will reach k distance from end 
    // 2. check if the had is null that means the nth node to delete is the head
    // 3. move slow and fast pointer by 1 till fast reaches to end of list
    // 4. as the fast reached to end, slow will point to the L-kth point such that we have to delete the node next to slow pointer
    
    public static Node removeKthNodeFromLast1(Node head,int k){

        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        for(int i=0;i<k;i++){
            fast = fast.next;
        } // now the fast pointer is k distance from the slow pointer
        
        if(fast==null) {// means we have to delete the first node of the list OR the Nth node from the end is the head
            Node newNode = slow.next;
            head = null;
            return newNode;
        }

        // move both the pointer until fast reaches to end
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        // delete the node next to the slow
        Node delNode = slow.next;
        slow.next = delNode.next;
        delNode = null;

        return head;

    }



    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(2);
        Node third = new Node(30);
        Node fourth = new Node(4);
        Node fifth = new Node(11);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        printList(head);
        head = removeKthNodeFromLast1(head,5);
        
        printList(head);
    }
}
