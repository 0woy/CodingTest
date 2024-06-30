package LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class N_21 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head= new ListNode();
        ListNode tmp = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }
            else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1!=null){
            tmp.next =list1;
        }
        if(list2!=null){
            tmp.next = list2;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode b2 = new ListNode(4);
        ListNode a2 = new ListNode(3,b2);
        ListNode b1 = new ListNode(4);
        ListNode a1 = new ListNode(2,b1);
        ListNode list1 = new ListNode(1, a1);
        ListNode list2 = new ListNode(1,a2);

        mergeTwoLists(list1, list2);


    }
}
