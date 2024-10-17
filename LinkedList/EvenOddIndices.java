package LinkedList;
import java.util.*;
public class EvenOddIndices {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    // Brute Force
    // TC : O(N) SC : O(N)
    // BY taking the arraylist to store the data
    public static Node evenOddIndices2(Node head){

        if(head == null || head.next == null) return head;

        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;

        // FOR ODD INDEXES ELEMENT
        while(temp!=null && temp.next!=null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        // as if thier is odd no 1 2 3 
        // and we migh will skip to add 3 in array list coz that is skipped by the condition temp.next!=null
        if(temp!=null) list.add(temp.data);

        // FOR THE EVEN INDEX ELEMENTS
        temp = head.next;
        while(temp!=null && temp.next!=null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        
        temp = head;int i=0;
        while(temp!=null){
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    // Approach 1 
    // we will take 2 dummy nodes and 
    //  Basic idea is just group all the nodes onr for even indices and one for odd indices and then the even indices group will come after odd indices group.
    public static Node evenOddIndices(Node head){

        Node oddHead = new Node(-1);
        Node oddTail = oddHead;

        Node evenHead = new Node(-1);
        Node evenTail = evenHead;

        Node curr = head,temp=head;
        int index = 1;
        while(curr!=null){

            // detach the element from the next element
            temp = curr;
            curr = curr.next;
            temp.next = null;

            if(index%2 != 0){
                oddTail.next = temp;
                oddTail = temp;
            }else{
                evenTail.next = temp;
                evenTail=temp;
            }

            // curr = curr.next;
            index++;
        }
        evenHead = evenHead.next; // as thier is dummy node at start of even head so we just removed that
        oddTail.next = evenHead; // attached the even list head to the oddlist tail

        return oddHead.next; // as thier is dummy node at oddHead we returned next node as head

    }

    // Approach - II
    public static Node evenOddIndices1(Node head){


        int index = 1;
        // took 2 pointers
        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // to store the even head later we can join the odd last to this evenHead

        // even will always ahead of the odd
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // as we have the odd at the last index of the odd list make the link between them

        odd.next=evenHead;
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

        Node ans = evenOddIndices2(head);
        
        printList(ans);
    }
}

/* SAME AS APPROACH- I
 * 
 * class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        ListNode curr = head;
        int i = 1;
        while(curr!=null){
			// generate the odd indices list
            if(i%2==1){
                if(oddHead==null){
                    oddHead = curr;
                    oddTail = curr;
                }
                else{
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
			// generate the even indices list
            else{
                if(evenHead==null){
                    evenHead = curr;
                    evenTail = curr;
                }
                else{
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
            i++;
        }
        
        evenTail.next = null;     // there should not be any node after even tail
        oddTail.next  = evenHead;   // join even list after odd
        return oddHead;
    
    }
}
*/