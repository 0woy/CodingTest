import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if(a!=b){
                    return a-b;
                }
                return o1.intValue()-o2.intValue();
            }
        });

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                int res = que.isEmpty()?0:que.poll();
                bw.write(res+"\n");
            }
            else{
                que.add(num);
            }
        }

        bw.flush();
        bw.close();
    }
}
