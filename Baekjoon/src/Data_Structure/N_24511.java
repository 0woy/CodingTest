package Data_Structure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> que = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringTokenizer nums = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int ds = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(nums.nextToken());
            if(ds ==  0){
                que.addFirst(cur);
            }
        }

        int m = Integer.parseInt(br.readLine());
        nums = new StringTokenizer(br.readLine());
        while(m -- > 0){
            que.add(Integer.parseInt(nums.nextToken()));
            bw.write(que.poll()+" ");
        }
        bw.flush();
        bw.close();
    }
}
