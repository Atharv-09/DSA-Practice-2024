package LinkedList;

public class DetectACycleIndec_SLL {
    
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node getIndexWhereCycleStarts(Node head){

        // brute force , take the hashmap to store the node,1 such that if the same node we reach then return that node index

        // optimal
        // Using Hare and Tortoise Alogorithm
        // we will take the slow and fast pointers such that at some point they are equal that means thrir is cycle
        // when they are at same point make the slow at the head and again go slow by 1 and fast by 2 again where they meet that is the starting point of the cycle
        // but how they meet again and how that point is the starting point of cycle? 

        
        Node slow = head;
        Node fast = head;

        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
        
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;  
            }
            
        }
        // if(slow!=fast) return null; // thier is not a cycle

        return null;

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
        fifth.next = third;
        // 1 - > 2 -> 3 -> 4 -> 5;
        //            |_________|

        System.out.println(getIndexWhereCycleStarts(head).data);
    }
}
