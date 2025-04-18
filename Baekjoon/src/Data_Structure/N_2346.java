package Data_Structure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<int[]> deque = new ArrayDeque<>();
        int n  =Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx =1;
        while (st.hasMoreTokens()){
            deque.add(new int[]{idx++,Integer.parseInt(st.nextToken())});
        }
        int [] next = deque.removeFirst();
        int step = next[1];
        bw.write(next[0]+" ");
        while(!deque.isEmpty()){
            boolean fTol =step>0?true:false;
            step = Math.abs(step)-1;
            int res = -1;
            if(fTol){
                while(step-- >0){
                    deque.addLast(deque.removeFirst());
                }
                next = deque.removeFirst();
            }else {
                while (step-- > 0) {
                    deque.addFirst(deque.removeLast());
                }
                next = deque.removeLast();
            }
            bw.write(next[0]+" ");
            step = next[1];
        }
        bw.flush();
        bw.close();
    }
}
