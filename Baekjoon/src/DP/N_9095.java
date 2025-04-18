package DP;

import java.io.*;

public class N_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while(tc>0){
            int n = Integer.parseInt(br.readLine());
            int [] dp = new int[n+3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
            bw.write(dp[n]+"\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }
}
