import java.io.*;
import java.util.PriorityQueue;

public class N_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n>0){
            pq.add(Integer.parseInt(br.readLine()));
            n--;
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll()+"\n");
            //bw.write(pq.poll()+"\n");
        }
        System.out.println(sb.toString());
        //bw.flush();
        //bw.close();

    }
}
