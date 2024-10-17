package LinkedList;
/*You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

ex : 4 - 5  - 6 => 4 - 5 - 7 
9 9 9 -> 1 0 0 0

 */
public class Add_1AtEnd_LinkedList {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node reverseSLL(Node head){
        if(head == null || head.next == null) return head;

        Node temp = head;
        Node prev = null;
        Node next = null;

        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    // TC : O(3xN) [as we are reversing, looping, again reversing]
    // brute
    public static Node add1toEndOfLL(Node head){

        // Node temp = head;
        Node revList = reverseSLL(head);
        Node temp = revList;
        Node prev = null;

        int carry = 1;
        while(temp!=null){

            int add = temp.data + carry;

            if(add == 10){
                temp.data = 0;
                carry = 1;
                prev = temp;
                temp = temp.next;
            }else{
                temp.data +=carry;
                carry = 0;
                break;
            }
            
        }

        if(carry == 1){
            Node newNode = new Node(carry);
            prev.next = newNode;
            newNode.next = null;
        }
        return reverseSLL(revList);
    }

    //------------------------------------------

    // optimal : recursive 
    // TC : O(N) SC: O(N) [recursive stack]
    public static int helper(Node temp){

        if(temp == null) return 1; // when we are at the very deep down in stack i.e we are at last element we have to add 1 thier so return 1 from base case as carry

        int carry = helper(temp.next);

        temp.data += carry;

        if(temp.data < 10){
            return 0;
        }else{
            temp.data = 0;
            return 1;
        }
    }
    public static Node add1toEndOfLL1(Node head){

        Node temp = head;
        
        int carry = helper(temp); // here it will get the last carry
        // if carry is 1 means we need to add a newNode and if carry is 0 no need to add a new node
        if(carry == 1) {// we need to add new node at front as at last the carry remaining as 1

            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        // as the carry is 0 no need to add new node at frnt
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node second = new Node(9);
        Node third = new Node(9);
        Node fourth = new Node(9);
        Node fifth = new Node(9);
        Node six = new Node(9);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;
        printList(head);
        
        Node newHead = add1toEndOfLL1(head);
        
        printList(newHead);
    }
}
