package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
class ListNode{
    private Integer data;
    public ListNode link;

    public ListNode(){
        this.data = null;
        this.link=null;
    }

    public ListNode(int data) {
        this.data = data;
        this.link = null;
    }

    public int getData(){return this.data;}

}


class LinkedQueue{
    private ListNode head;
    public LinkedQueue(){
        this.head=null;
    }

    public void insert_last(int recur){
        for(int i=1;i<=recur;i++) {
            ListNode newNode = new ListNode(i);

            // if LinkedList is null
            if (head == null) {
                head = newNode;
                newNode.link = head;
            }

            // if LinkedList is not null
            else {
                ListNode tmp = head;

                // find the last node
                for (; tmp.link != head; tmp = tmp.link) {
                }
                newNode.link = tmp.link;
                tmp.link = newNode;  // insert the newnode to que's last
            }
        }
    }


    public StringBuilder delete(int pos, StringBuilder sb){
        sb.append("<");
        ListNode tmp =head;
        if(pos ==1){
            while(tmp.link !=head){
                sb.append(tmp.getData()).append(", ");
                tmp = tmp.link;
            }
            sb.append(tmp.getData()).append(">");
        }

        else {
            while (tmp != null) {
                ListNode remove;
                for (int i = 1; i < pos - 1; tmp = tmp.link, i++) {
                }
                if (tmp.link == tmp) {
                    sb.append(tmp.getData()).append(">");
                    tmp = null;
                    break;
                } else {
                    remove = tmp.link;
                    int data = remove.getData();
                    tmp.link = remove.link;
                    remove = null;

                    tmp = tmp.link;
                    sb.append(data).append(", ");
                }
            }
        }
        return sb;
    }

}

public class N_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedQueue q = new LinkedQueue();
        q.insert_last(n);

        sb=q.delete(k,sb);
        System.out.print(sb);

    }
}
 */
class N_1158{
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int idx =0;
        sb.append("<");
        while(list.size()>1){
            idx += k-1;
            if(idx>=list.size()){
                idx%=list.size();
            }
            sb.append(list.remove(idx)+", ");
        }
        sb.append(list.get(0)+">");

        System.out.println(sb.toString());

    }

}
