package LinkedList;

import java.util.HashMap;

// iven the linked list create a Create a ‘deep copy’ of the given linked list and return it.

public class CloneSLLWithNextNRandomPtr {
    static class Node{

        int data;
        Node random;
        Node next;
    
        Node(int data){
            this.data = data;
            random=next=null;
        }
    }
    public static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            // Move to the next node in the list
            head = head.next;
        }
    }

    // BRUTE FORCE 
    // Using hashmap
    // we will simple create the hasmap(node,node) such that key-org node and value-copy of org node which we will create
    // TC : O(N) + O(N)
    // SC : O(N) -> for hashmap + O(N) -> to store the copied value which was said in the Question itself
    private static Node cloneLL(Node head){

        if(head == null) return null;
        Node temp = head;
        HashMap<Node,Node> map = new HashMap<>();

        // create the dummy nodes/copy nodes and put it into map with key as org node and values as this newly created copy nodes
        while (temp!=null) {
            Node newNode = new Node(temp.data);
            map.put(temp,newNode);
            temp = temp.next;
        }

        // connect the pointers
        temp = head;
        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next); // we will make a pointer from a copied node to the the next copied node
            copyNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head); // as the head value will store the head value of the copied node 

    }


    //-----------------------------------------------------------------------------------------

    // OPTIMAL 
    // By creating the nodes in between the org nodes and then joining the pointers

    // TC : 

    static void createCopyNodes(Node head){
        Node temp = head;
        
        while(temp != null){
            
            Node newNode = new Node(temp.data);
            newNode.next = temp.next; // new node will point to the temp's next node as we have to place this new Node in between them
            temp.next = newNode; // temp will point to this newNode 
            // temp [newNode] temp.next
            temp = temp.next.next; // as this new node is added ni between to go into org array next we have to do temp.next.next
        }
    }

    static void connectRandomPointers(Node head){
        
        Node temp = head;
        
        while(temp != null){

            Node copyNode = temp.next;
            
            if(temp.random == null) {
                // if the temp random points to null
                copyNode.random = null; 
            }else{
                copyNode.random = temp.random.next; // as on the temp.random's next only the copy node is present
            }
            temp = temp.next.next;
        }
    }
    public static Node getDeepCopy(Node head){
        Node temp = head;
        Node dum = new Node(-1);
        Node rev = dum;

        while(temp != null){

            rev.next = temp.next;// to make the connection between the copy nodes
            temp.next = temp.next.next; // to make the connection between the org nodes as we have added the copy nodes in bettween this will point to it's next org node

            temp = temp.next;
            rev = rev.next;
        }

        return dum.next;
    }
    private static Node cloneLL1(Node head){

        if(head == null) return null;
        
        // 1. insert a copy nodes in between org nodes.
        
        createCopyNodes(head);

        // 2. Join the random pointers

        connectRandomPointers(head);

        // 3. Join the next pointers ( and retrive the deepedst copy of the list)

        return getDeepCopy(head);
    }
    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        printClonedLinkedList(head);

        cloneLL1(head);

        printClonedLinkedList(head);
    }
}
