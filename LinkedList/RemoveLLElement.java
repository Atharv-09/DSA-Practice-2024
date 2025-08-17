
/*Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
*/
public class RemoveLLElement {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Approach by taking dummy node such that if we encounter same value as val so we will skip that and take its next element 
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1);
        ListNode temp = dum;

        dum.next = head;
        while(temp.next!=null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return dum.next;
    }


    // Instead of taking extra dum object
    // we will skip all the same as val from start such that our head points to the first non matching val
    // then iterate and cehck if the next val is same we will make its next to its next-next (we skipped)
    // if not same then we will just increement node

    public ListNode removeElements2(ListNode head, int val) {
        while(head!= null && head.val == val){
            head = head.next;
        }
        ListNode node = head;
        while(node!=null && node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return head;
        
    }
    

    // Recursive
    // we will call till depth and if the null list return null
    // if that head values is same as val then we will return head.next (means we skipped that head)
    // if not same then we will return head only
    
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
