package DP;

import java.io.*;

public class N_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while(tc > 0){
            int n = Integer.parseInt(br.readLine());
            int [][] dp = new int[n+2][];
            dp[0] = new int[]{1,0};
            dp[1] = new int[]{0,1};

            for (int i = 2; i <= n; i++) {
                dp[i] = new int[2];
                dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
                dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
            }
            bw.write(dp[n][0]+" "+dp[n][1]+"\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }
}
