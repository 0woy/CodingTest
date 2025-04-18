import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class N_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> que = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while(que.size()>1){
            que.removeFirst();
            que.addLast(que.removeFirst());
        }
        System.out.println(que.removeFirst());

    }
}
