package LinkedList;
/** 문제
Given the head of a linked list,
remove the nth node from the end of the list and return its head.

 */

public class N_19 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static int findListLen(ListNode head){
        int len =0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        return len;
  }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        while(--n >1){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void printList(ListNode list){
        while(list!=null){
            System.out.print(list.val+" ");
            list =list.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n =1;
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        printList(head);
        int size = findListLen(head);
        n = size -n+1;
        if(n == 1){
            head = head.next;
        }
        else {
            head = removeNthFromEnd(head, n);
        }
        printList(head);


    }
}
