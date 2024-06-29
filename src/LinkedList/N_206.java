package LinkedList;
public class N_206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode root){
        ListNode q = root;
        ListNode r = null;
        while(root!=null){
            q=root;
            root = root.next;
            q.next = r;
            r=q;
        }

        return r;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        root.next = a;
        a.next=b;
        b.next=c;
        c.next=d;


        ListNode tmp = reverseList(root);
        while(tmp!=null){
            System.out.print(tmp.val+" ");
            tmp= tmp.next;
        }
    }
}
