package LinkedList;
import java.util.*;
public class LengthOfLoop_SLL {
    
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    //BRUTE FORCE : TC : O(N) SC : O(N)
    // Using HashMap
    public static void lengthOfLoop(Node head){
        
        HashMap<Node,Integer> map =new HashMap<>();

        Node temp = head;
        int timer = 1;
        while(temp!=null){

            if(map.containsKey(temp)){
                System.out.println(timer-map.get(temp));
                return;
            }

            map.put(temp,timer);
            timer++;
            temp = temp.next;
        }
        System.out.println(0);
    }

    public static int getLength(Node slow,Node fast){

        int count = 1;
        fast = fast.next; // fast will move in the loop till he met slow pointer
        while(fast!=slow){
            fast = fast.next; // move fast pointer
            count++; // take the count of the elenments in the looop
        }
        return count;
    }

    public static void lengthOfLoop1(Node head){

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
          
            if(slow == fast){ // as we met to the one point one slow index will at that point only and fast will traverse the loop and take counter increase as we move to next elements

                int length = getLength(slow,fast);
                System.out.println(length);
                return;
            }
        }
        System.out.println(0);

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = second;
        // 1 - > 2 -> 3 -> 4 -> 5;
        //            |_________|

        lengthOfLoop1(head);
    }
}
