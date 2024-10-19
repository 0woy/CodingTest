import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0,idx=0;

        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            max = Math.max(max, cur);
            scores[idx++] = cur;
        }
        double total = 0;
        for(double val: scores){
            val =  val/max*100;
            total+=val;
        }
        System.out.println(total/n);
    }
}
