package LinkedList;
import java.util.*;
public class FindIntersectionIn_SLL {
    

    // As we know the intersecion means thier is come common nodes 
    // iterate both the list such that is thier is common node return that node else return null;
    // TC : O(NxM) SC : O(1)

    static Node findIntersectionPoint(Node head1,Node head2){
         Node temp1 = head1;
         while(temp1!=null){
            Node temp2 = head2;
            while(temp2!=null){
                if(temp1 == temp2) return temp1;
                temp2 = temp2.next;
            }   
            temp1 = temp1.next;
         }
         return null;
    }

    // Approach 2 
    // Using Hashing
    // we will put the nodes into hashset and traverse first head1 list then head2 list if somewhere the node already thier that means thier is intersection
    // TC : O(N+M) SC : O(N)

    static Node findIntersectionPoint1(Node head1,Node head2){

        HashSet<Node> set = new HashSet<>();
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1!=null){
            set.add(temp1);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            if(set.contains(temp2)) return temp2;
            set.add(temp2);
            temp2 = temp2.next;
        }

        return null;
    }

    // length difference
    // TC  :2*O(N+M) SC : O(1)
    static Node findIntersectionPoint2(Node head1,Node head2){

        int len1 = 0;
        int len2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1!=null){
            len1++;
            temp1 = temp1.next;
        }

        while(temp2!=null){
            len2++;
            temp2 = temp2.next;
        }
        temp1 = head1;
        temp2 = head2;
        // take the pointer to the differnce distance and then check each pointer where they are same return that node
        if(len1>len2){
            while(len1!=len2){
                temp1 = temp1.next;
                len1--;
            }
        }else{
            while(len1!=len2){
                temp2 = temp2.next;
                len2--;
            }
        }

        while(temp1!=null && temp2!=null){

            if(temp1==temp2) return temp1;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    //optimal 
    // by taking 2 pointer t1,t2 such that if the some of the pointer reached to null then instead of breaking
    // make that pointer to the next list head if t1 nulls then it point to head2 and if t2 nulls then it points to head1
    // TC : O(N1+N2) 

    static Node findIntersectionPoint3(Node head1,Node head2){

        if(head1 == null || head2 == null) return null;

        Node t1 = head1;
        Node t2 = head2;

        while(t1!=t2){
            
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;
            if(t1.next == null) t1 = head2;
            if(t2.next == null) t2 = head1;
            
            // check if the t1 pointer is at null for head1 list put that pointer to the head2
            // t1 = (t1==null) ? head2 : t1.next;
            // if t2 pointer is at the null pointer then put that t2 to list1 head1 
            // t2 = (t2==null) ? head1 : t2.next;
        }
        return t1;

    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node second = new Node(4);
        Node third = new Node(2);
        Node fourth = new Node(9);
        Node fifth = new Node(10);
        Node six = new Node(11);
        // 1 4 2 9 10 11
        // 6 17 18 (joint to 9)
        head1.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = null;

        Node head2 = new Node(6);
        Node second1 = new Node(17);
        Node third1 = new Node(18);
        head2.next = second1;
        second1.next = third1;
        third1.next = fourth;

        Node intersectedNode = findIntersectionPoint3(head1,head2);
        System.err.println(intersectedNode.data);
    }
}
