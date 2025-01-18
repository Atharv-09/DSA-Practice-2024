package LinkedList;
import java.util.*;
public class FindPairsWithGivenSum {
    static class Node{

        int data;
        Node prev;
        Node next;
    
        public Node(int data){
            this.data = data;
            next=prev=null;
        }
    }
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node insertAtEnd(Node head,int data){

        Node newNode = new Node(data);

        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;

        return head;
    }
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;

        head = insertAtEnd(head,5);
        head = insertAtEnd(head,6);
        head = insertAtEnd(head,8);
        head = insertAtEnd(head,9);
        // head = insertAtEnd(head,2);
        
        printList(head);

        ArrayList<ArrayList<Integer>> ans = findAllPairsWithSum(head,6);

        for(ArrayList<Integer> list : ans){
            for(int k:list){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }

    // brute force
    // We will take 2 pointer at head and do like nested for loop and check if thier sum are equal to i
    // TC : O(N^2) SC : O(pairs Count)
    private static ArrayList<ArrayList<Integer>> findAllPairsWithSum1(Node head, int i) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Node temp1 = head;
        while(temp1 != null){

            Node temp2 = temp1.next;
            while(temp2!=null && temp1.data+temp2.data <= i){
                if(temp1.data+temp2.data == i){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);pair.add(temp2.data);
                    result.add(pair);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return result;

    }
    // optimal - using 2 pointer low and high as the list is sorted and list is DLL we can move from back to front also
    // TC : O(N) 
    private static ArrayList<ArrayList<Integer>> findAllPairsWithSum(Node head, int i) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(head == null || head.next == null) return null;

        Node temp = head;
        // get the tail node for high
        while(temp.next!=null) temp = temp.next;

        Node low = head;
        Node high = temp;
        

        while(low.data < high.data){

            int sum = low.data + high.data;
            if(sum == i){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(low.data);pair.add(high.data);
                result.add(pair);
                low = low.next;
                high = high.prev;
            }else if(sum > i){
                high = high.prev;
            }else{
                low = low.next;
            }
        }

        return result;
    }
}
