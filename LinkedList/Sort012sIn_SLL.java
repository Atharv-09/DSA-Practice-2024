package LinkedList;

public class Sort012sIn_SLL {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }


    // Brute force 
    // Take and array put this data into that and sort and again put that sorted data back into list
    // TIME : O(Nxlogn) SPACE : O(N)

    // Better
    // We can take the count of 0,1,2 and accordingly put the data into the list
    static Node sortArraysOf012s_brute(Node head) {
        // add your code here
        Node temp = head;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        while (temp != null)
        {
            if (temp.data == 0)
            {
                count0++;
            }
            else if (temp.data == 1)
            {
                count1++;
            }
            else 
            {
                count2++;
            }
            
            temp = temp.next;
        }
        
        temp = head;
        // instead of below 3 loops we can 
        /*while(temp!=null){
            if(count0>0){
                temp.data = 0;
                count0--;
            }else if(count1>0){
                temp.data = 1;
                count1--;
            }else{
                temp.data =2;
                count2--;
            }
            temp = temp.next;
        } */
        while (count0 != 0)
        {
            temp.data = 0;
            temp = temp.next;
            count0--;
        }
        
        while (count1 != 0)
        {
            temp.data = 1;
            temp = temp.next;
            count1--;
        }
        
        while (count2 != 0)
        {
            temp.data = 2;
            temp = temp.next;
            count2--;
        }
        
        return head;
    }


     // Optimal by using pointers
    public static Node sortArraysOf012s(Node head){

        if(head == null) return null;

        Node zeroHead = new Node(-1),zero=zeroHead; // take one temp0 
        Node oneHead = new Node(-1),one=oneHead;
        Node twoHead = new Node(-1),two=twoHead; // take one temp2 for dum2 reference
        
        Node temp = head;
        while(temp!=null){

            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }else{
                two.next = temp;
                two=two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next; // suppose thier are no ones then the oneHead next is null so we putted if oneHead next is not null then point to one else point to teoHead.next
        one.next = twoHead.next;
        two.next = null;
        
        return zeroHead.next;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(0);
        Node third = new Node(2);
        Node fourth = new Node(1);
        Node fifth = new Node(0);
        Node six = new Node(1);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;
        printList(head);
        
        Node newHead = sortArraysOf012s(head);
        
        printList(newHead);
    }
}
