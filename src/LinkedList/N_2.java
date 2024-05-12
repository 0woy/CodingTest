package LinkedList;

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next;
     }

public class N_2 {
         /* 풀이 확인 전 코드
    public static ListNode reverse(ListNode list){
        ListNode cur =null;
        ListNode nextNode = list;
        ListNode reverse = cur;
        while(nextNode!=null){
            cur = nextNode;
            nextNode = nextNode.next;
            cur.next = reverse;
            reverse = cur;
        }
        return reverse;
    }
    public static String IntToStr(ListNode list){
        String str ="";
        while(list!=null){
            str+=String.valueOf(list.val);
            list = list.next;
        }
        return str;
    }
    public static ListNode insertNode(int val,ListNode result){
        ListNode newNode = new ListNode(val);

        if(result == null){
            return newNode;
        }
        else{
            ListNode tmp = result;
            while(tmp.next!=null){
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        return result;
    }
    public static void printList(ListNode list){
        while(list!=null){
            System.out.print(list.val+" ");
            list =list.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = new ListNode();
        ListNode r2 = new ListNode();

        r1 = reverse(l1);
        r2 = reverse(l2);
        printList(r1);

        String s1 = IntToStr(r1);
        String s2 = IntToStr(r2);

        long res = Long.parseLong(s1)+Long.parseLong(s2);
        ListNode result = new ListNode();
        while(true){
            long addValue = res%10;
            result = insertNode((int)addValue,result);

            if(res/10 == 0) break;
            res /=10;
        }

        printList(result);
        //System.out.print(res);
        return result.next;
    }
           */

    // 정답 풀이
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);  // 결과로 반환될 ListNode
        ListNode tmp = result;  // result의 마지막 노드를 가리키기 위한 변수
        int carry =0;   // 올림수

        while(l1!=null || l2!=null||carry!=0){
            int d1 = (l1!=null)?l1.val:0;   // l1의 현재 수
            int d2 = (l2!=null)?l2.val:0;   // l2의 현재 수

            int sum = d1+d2+carry;
            int digit = sum%10; // 현재 노드에 저장될 수
            carry = sum/10;     // 10 이상인 경우 다음 노드 값을 1 더하여 저장

            ListNode newNode = new ListNode(digit); // 노드 생성
            tmp.next = newNode; // 노드 삽입
            tmp = tmp.next;     // 다음 노드로 이동

            l1 = (l1!=null)?l1.next:null;   
            l2 = (l2!=null)?l2.next:null;
        }
        return result.next; // 결과값 반환
    }
    public static void main(String[] args) {

    }
}
}
