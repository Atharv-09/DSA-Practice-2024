package LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FlattenALinkedList {
    
    static class Node {
        int data;
        Node next;
        Node child;
    
        // Constructors to initialize the
        // data, next, and child pointers
        Node(int data) {
            this.data = data;
            next = null;
            child = null;
        }

    }
    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }
    static void printOriginalLinkedList(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    // -------------------------------------------------------------------------------
    // BRUTE FORCE : Using the extra space
    // we took array and store all the nodes data into that and then we sorted that array
    // now using dummy nodes we crreated a child nodes using the sorted array

    // TC : O(N*M) to put elements in array + O((N+m)logn(N+m)) to sort + O(m+n) to sort the array and created new nodes
    // SC : O(N+M) [n-horizontal size of nodes and m-vertical size/depth of nodes]

    static Node createNodesFromArray(ArrayList<Integer> arr){

        if(arr.size() == 0) return null;
        Node dum = new Node(-1);
        Node temp = dum;

        for(int x:arr){
            Node newNode = new Node(x);
            temp.child = newNode;
            temp = temp.child;
        }
        return dum.child;
    }
    static Node flattenLinkedList(Node head){

        if(head == null || head.next==null) return head;

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = head;

        while(temp1!=null){

            Node temp2 = temp1;
            while(temp2!=null){
                arr.add(temp2.data);
                temp2 = temp2.child;
            }
            temp1 = temp1.next;
        }

        Collections.sort(arr);
        // create the nodes

        return createNodesFromArray(arr);
    }


    // -------------------------------------------------------------------------------

    // OPTIMAL 
    // As ther were mentioned that the lists are sorted in vertical order so we don't need sorting algo to sort
    // and in brute we are creating the new nodes instead of using the same one which will take more space
    // take from last merge the two list return (again merge the curr list and that previous merged list)
    
    // TC  : O(N * merge) = O(n * (m+m) = O(2 NxM);
    // SC : O(1)
    static Node mergeTwoList(Node list1,Node list2){

        if(list1 == null && list2 == null) return null;
        Node dum = new Node(-1);
        Node temp = dum;

        while(list1 != null && list2 != null){

            if(list1.data < list2.data){
                temp.child = list1;
                temp = list1; // we incremented temp to next position
                list1 = list1.child; // made list1++0
            }else{  
                temp.child = list2;
                temp = list2; // incremented temp to next pointer
                list2 = list2.child;
            }
        }

        if(list1!=null){
            temp.child = list1;
        }
        if(list2!=null){
            temp.child = list2;
        }

        return dum.child;
    }
    static Node flattenLinkedList1(Node head){

        if(head == null || head.next==null) return head;            
        // here the merged list will get 
        Node mergedHead = flattenLinkedList(head.next); // we will go at depth
        // we will return the two merged list i.e currlist + the list merged from the last 
        return mergeTwoList(head, mergedHead);
    }
    public static void main(String[] args) {
        // Create a linked list with child pointers
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        // Print the original
        // linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten the linked list
        // and print the flattened list
        Node flattened = flattenLinkedList1(head);
        System.out.println("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
