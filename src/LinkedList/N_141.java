package LinkedList;
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list
if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class N_141 {
    public static class ListNode {
        int val;
        ListNode next;
        boolean ischecked;
        ListNode(int val) {
            this.val = val;
            next = null;
            ischecked = false;
        }
    }

    public static boolean hasCycle(ListNode head){
        ListNode fast =head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        cycle.next= new ListNode(0);
        cycle.next.next= new ListNode(-4);
        cycle.next.next.next = cycle;
        boolean res= hasCycle(head);
        System.out.println(res);

    }
}
