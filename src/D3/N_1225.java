package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que;
        for(int t=1;t<=10;t++){
            sb.append("#"+t+" ");
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            que = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                que.add(Integer.parseInt(st.nextToken()));
            }
            int plus =1;
            while(true){
                int cur =que.poll();
                if(plus > 5){
                    plus=1;
                }
                cur -=plus;
                if(cur <=0){
                    cur =0;
                    que.add(cur);
                    break;
                }
                que.add(cur);
                plus++;
            }
            for(int v: que){
                sb.append(que.poll()+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
