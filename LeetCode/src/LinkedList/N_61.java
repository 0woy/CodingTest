package LinkedList;

public class N_61 {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    // FirstTry: Cycle error
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode tmp = head;
        int size =1;
        while(tmp.next!=null){
            size++;
            tmp = tmp.next;
        }
        if(size <= k){
            k %=size;
        }
        tmp.next =head;
        tmp = head;
        ListNode start = tmp;
        size = size-k;
        while(size > 1){
            tmp = tmp.next;
            size--;
        }
        start = tmp.next;
        tmp.next=null;

        return start;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0,
                new ListNode(1 ,
                new ListNode(2)));

        rotateRight(head, 4);
    }
}
