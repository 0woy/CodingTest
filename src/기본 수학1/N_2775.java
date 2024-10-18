import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc>0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int [] dp = new int[n];
            for(int i=0;i<n;i++){
                dp[i]= i+1;
            }

            for(int floor=0;floor<k;floor++){
                for(int i=1;i<n;i++){
                    dp[i] = dp[i-1]+dp[i];
                }
            }
            sb.append(dp[n-1]+"\n");
            tc--;
        }
        System.out.println(sb.toString());

    }
}
