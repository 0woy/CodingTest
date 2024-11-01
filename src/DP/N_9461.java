package DP;

import java.io.*;

public class N_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc -- >0){
            int n =Integer.parseInt(br.readLine());
            long [] dp = new long[n+3];
            dp[0] =0;
            dp[1] =1;
            dp[2] =1;
            dp[3] =1;
            for(int i=4;i<=n;i++){
                dp[i] = dp[i-3]+dp[i-2];
            }
            bw.write(dp[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
