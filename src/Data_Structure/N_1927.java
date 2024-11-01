package Data_Structure;

import java.io.*;
import java.util.PriorityQueue;

public class N_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int len = Integer.parseInt(br.readLine());

        while(len-- > 0){
            int op = Integer.parseInt(br.readLine());
            if(op ==0){
                if(pq.isEmpty()){
                    bw.write(0+"\n");
                }
                else {
                    bw.write(pq.poll()+"\n");
                }
            }
            else{
                pq.add(op);
            }
        }
        bw.flush();
        bw.close();
    }
}
