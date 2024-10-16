package LinkedList;
import java.util.*;
public class SLL_PalindromeOrNot {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node reverseASLL(Node node){

        if(node == null || node.next == null) return node;

        Node prevNode = null;
        Node nextNode = null;
        while(node != null){
            nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }

        return prevNode;
    }

    // BRUTE FOrce 
    // We will use stack to store the data of the element as it store in LIFO 
    // again traverse the list and check the currElement of list is equal to the top element of stack , if not equal then return false
    // TIME : O(N) SPACE :O(N)
    public boolean palindromeCheck(Node head) {
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        // Reset the temporary pointer back to head
        temp = head;

        while (temp != null) {
            if (temp.data != st.peek()) {
                // If values don't match,
                return false;
            }
            st.pop();
            temp = temp.next;
        } 
        // If all values match,
        return true;
    }


    // Better
    // TIME : 2*O(N) SPACE : O(1)
    public static boolean palindromeCheck1(Node head){

        Node temp = head;
        Node rev = reverseASLL(temp); // take the reverse list head
        // traver through both the list rev and actual
        // if some of the data doesn't matches then return false as it is not palindrome
        while(temp!=null){

            if(temp.data != rev.data) return false;
            temp = temp.next;
        }

        return true;
    }


    // OPTIMAL
    // Instead of reverse whole list we can reverse the second half of the list and compare with the first half of list
    // Get the mid elememt and revers the second half and compare first and second half
    // then make the seond half to its orginal position (As we reversed)

    // O(2*N)
    public static boolean palindromeCheck2(Node head){

        if(head == null || head.next==null) return true;

        Node slow = head;
        Node fast = head;

        // if we have odd 
        // 1 - 2 - 3 - 2 - 1 (here slow is at 3 when the fast reaches last index) (fast.next!=null)
        // 1 - 2 - 3 - 3 - 2 - 1 (here slow points at first 3  when the fast reached to second last index) (Fast.next.next!=null)
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseASLL(slow.next);

        Node first = head;
        Node second = newHead;
        while(second!=null){
            if(first.data != second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        slow.next = reverseASLL(newHead);

        return true;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(1);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        System.out.println(palindromeCheck2(head));
    }
}
