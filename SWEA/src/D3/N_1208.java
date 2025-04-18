package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1;t<=10;t++){
            sb.append("#"+t+" ");
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            while(st.hasMoreTokens()){
                int cur = Integer.parseInt(st.nextToken());
                min.add(cur);
                max.add(cur);
            }
            while(dump -- >0){
                int small  = min.poll();
                int large = max.poll();
                small++;
                large--;
                min.add(small);
                max.add(large);
            }
            int low = min.poll();
            int high = max.poll();

            sb.append(high-low+"\n");
        }

        System.out.println(sb.toString());
    }
}
