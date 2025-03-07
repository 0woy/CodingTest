import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] answer = new int[]{1,1,2,2,2, 8};

        int idx =0;
        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            answer[idx] = answer[idx]-cur;
            idx++;
        }
        for(int i: answer){
            System.out.print(i+" ");
        }
    }
}
