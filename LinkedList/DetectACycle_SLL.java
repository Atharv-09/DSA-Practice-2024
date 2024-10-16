package LinkedList;

import java.util.HashSet;

public class DetectACycle_SLL {

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    // Brute force
    // A loop in a linked list occurs when there's a node that, when followed, brings you back to it, indicating a closed loop in the list.

    // we can use hashset to add the node if we encounter any node and that node is already thier in the set means the loop is thier
    // TC :  O(N * 2 * log(N) ) [here n for the n nodes and 2logn for insertions and search in set] space : O(n)

    public static boolean detectLoopInSLL(Node head){

        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while(temp!=null){

            if(!set.contains(temp)){
                set.add(temp);
            }else{
                return true;
            }
            temp  = temp.next;
        }

        return false;
    }

    // Optimal approach using Hare and Tortoise Algorighthm
    // Thier weere 2 pointers slow and fast 
    /*When the tortoise and hare enter the loop, they may be at different positions within the loop due to the difference in their speeds. The hare is moving faster, so it will traverse a greater distance in the same amount of time.

If there is no loop in the linked list, the hare will eventually reach the end, and the algorithm will terminate without a meeting occurring.*/

    public static boolean detectLoopInSLL1(Node head){

        Node temp = head;
        Node slow = temp;
        Node fast = temp;

        while(slow!=null && fast!=null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
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
        // fifth.next = third;

        System.out.println(detectLoopInSLL1(head));
    }
}


// Time Complexity for BRUTE:  O(N * 2 * log(N) )The algorithm traverses the linked list once, performing hashmap insertions and searches in the while loop for each node. The insertion and search operations in the unordered_map have a worst-case time complexity of O(log(N)). As the loop iterates through N nodes, the total time complexity is determined by the product of the traversal (O(N)) and the average-case complexity of the hashmap operations (insert and search), resulting in O(N * 2 * log(N)). 