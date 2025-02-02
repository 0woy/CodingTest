package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] dp =new int[n];
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            dp[i] =1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = -1;
        for(int v: dp){
            max = Math.max(max,v);
        }
        System.out.println(max);
    }
}
