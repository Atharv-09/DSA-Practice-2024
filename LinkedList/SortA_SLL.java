package LinkedList;
import java.util.*;
public class SortA_SLL {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    // Brute force : 
    // We can use array to store the values of the nodes
    // we will store into arraylist and sort tha array list then put the values back to the node from the sorted arraylist
    // TC : O(nloogn)+O(n) SC : O(n)

    public static Node sortSLL1(Node head){
        List<Integer> arr = new ArrayList<>();
        Node temp = head;

        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(arr);
        
        temp = head;
        for(int i = 0; i < arr.size(); i++){
            temp.data = arr.get(i); 
            temp = temp.next; 
        }
        return head; 
    }

//------------------------------------------------------------------------------


    // TC : O(NlogN) SC : O(1)
    // optiimal solution : using the merge sort kind of
    // by taking the mid and divifing into 2 half and according to the values make them as sorted by taking dum node and return that new list
    public static Node merge2SortedLL(Node list1,Node list2){
        
        Node dum = new Node(-1);
        Node temp = dum;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        // if the lis1 / list2 has any element remaining to add in list so append that to that temp list
        if(list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return dum.next;
    }
    public static Node findMiddle(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next; // coz we want the exact mid elemnent such that for even length, len = 4 mid will at 2nd (1based indexing)
        // for odd , len = 5 mid will at 3rd index [occuring issue for even thats why we did this]

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node sortSLL(Node head){

        if(head == null || head.next==null) return head;

        Node middle = findMiddle(head);        

        // divide he ll in 2 halfs
        Node left = head; // fiirst half
        Node right = middle.next; // second half
        middle.next=null; // to make the first hald(left) list end as the null;
        
        left = sortSLL(left);
        right = sortSLL(right);

        return merge2SortedLL(left,right);
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
        fifth.next = six;
        six.next = null;
        printList(head);
        
        Node newHead = sortSLL(head);
        
        printList(newHead);
    }
}
