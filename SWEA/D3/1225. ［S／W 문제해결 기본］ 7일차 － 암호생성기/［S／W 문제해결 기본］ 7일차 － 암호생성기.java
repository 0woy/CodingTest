import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> que=new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append("#" + t + " ");
            String[] input = br.readLine().split(" ");

            for(String s: input){
                que.add(Integer.valueOf(s));
            }
            int n=1;
            while (true){
                int pop = que.pollFirst();
                pop = (pop-n>0)?pop-n:0;
                que.addLast(pop);
                if(pop == 0){
                    break;
                }
                n++;
                if(n==6) n=1;
            }
            while(!que.isEmpty()){
                sb.append(que.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
