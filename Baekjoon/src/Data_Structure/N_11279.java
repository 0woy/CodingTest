package Data_Structure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operation = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq =new PriorityQueue<>(Collections.reverseOrder());

        while(operation-- >0){
            long op =Integer.parseInt(br.readLine());
            if(op == 0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll()+"\n");
                }
            }
            pq.add(op);
        }
        bw.flush();
        bw.close();
    }
}
