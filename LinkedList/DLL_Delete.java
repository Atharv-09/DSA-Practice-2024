package LinkedList;

public class DLL_Delete {
    static Node head;
    static class Node{
        int data;
        Node prev;
        Node next;
    
        Node(int d){
            data = d;
            prev=next=null;
        }
    }
    public static void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    void push(int new_data){
            // 11 10 
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
         
        if(head!=null)  
            head.prev = new_node;
        head = new_node;

    }
    public static void deleteAtBeg(){

        if(head == null) return;
        /// 10

        head = head.next;
        if(head != null)
            head.prev = null;
    
    }
    public static void deleteAfterGiveNode(int key){

        Node temp = head;
        

        while(temp != null){
            if(temp.data == key) break;
            temp = temp.next;
        }
        if(temp == null || temp.next==null) return;
        // get the next node after temp which we have to delete
        Node nextNode = temp.next;
        // make the given node next as the nextNodeToDelete's next
        temp.next = nextNode.next;
        // make nextNode next's prev as the temp
        if(temp.next != null)
            nextNode.next.prev = temp;
        
    }

    public static void deleteBeforeGiveNode(int key){

        Node temp = head;
        while(temp != null){
            if(temp.data == key) break;
            temp = temp.next;
        }

        if(temp == null || temp.prev==null) return;

        Node prevNode = temp.prev; // node to delete
        temp.prev = prevNode.prev; // the currNode prev will be the prev node of the node tto be deleted

        if(prevNode.prev != null){
            prevNode.prev.next = temp; // the prevNode of node to be deleted is head node   
        }else{
            // if the prev is head
            head = temp;
        }

    }

    public static void deleteNodeAtxPosition(int x) {
        // code here
        if (head == null) {
            return;
        }
        int count = 1;
        Node temp = head;
        
        while(temp != null){
            if(x == count) break;
            
            temp = temp.next;
            count++;
        }
        if(temp==null) return;
      
        if(temp.prev!=null)
            temp.prev.next = temp.next;
        if(temp.next != null)
            temp.next.prev = temp.prev;
        
        if(temp == head){
            head = temp.next;
        }
        return;
    }
    public static void main(String[] args) {
        
        DLL_Delete dd = new DLL_Delete();
        dd.push(10);
        dd.push(12);
        dd.push(3);
        dd.push(18);
        dd.push(9);
        
        printList();

        // deleteAtBeg();
        
        deleteAfterGiveNode(18);
        printList();
        deleteBeforeGiveNode(10);
        printList();
        deleteNodeAtxPosition(3); 
        printList();

    }
}
