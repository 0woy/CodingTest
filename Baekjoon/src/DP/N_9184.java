package DP;

import java.io.*;
import java.util.StringTokenizer;

public class N_9184 {
    static int [][][] dp;
    public static int w(int a, int b, int c){

        if(!inNotRange(a,b,c) && dp[a][b][c]!=0){
            return dp[a][b][c];
        }

        if(a<=0 || b<=0 || c<=0){return 1;}

        else if(a>20 || b>20 || c>20 ){ return dp[20][20][20] = w(20,20,20);}

        else if(a<b && b<c) {
            return dp[a][b][c] =  w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        }

        else{
            return dp[a][b][c] =  w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }
    }
    public static boolean inNotRange(int a, int b, int c){
        return a<0 || b<0 || c<0
                || a>20 ||b>20 || c>20;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dp = new int[21][21][21];
        while(true){
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1){
                bw.flush();
                bw.close();
                return;
            }
            int res = w(a,b,c);
            bw.write("w("+a+", "+b+", "+c+") = "+res+"\n");
        }

    }
}
