package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+4];
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5]=1;
        for(int i=6;i<=n;i++){
            if(dp[i-3]!=-1 && dp[i-5]!=-1){
                dp[i] = Math.min(dp[i-3],dp[i-5])+1;
            }
            else if(dp[i-3]!=-1){
                dp[i] = dp[i-3]+1;
            }
            else if(dp[i-5]!=-1){
                dp[i] = dp[i-5]+1;
            }
            else{
                dp[i] = -1;
            }
        }
        System.out.println(dp[n]);


    }
}
