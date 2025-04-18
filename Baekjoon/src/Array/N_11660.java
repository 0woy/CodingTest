package Array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_11660 {
    /** 행 누적합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<arr.length;i++){
            st = new StringTokenizer(br.readLine());
            int col = 1;
            int prev =0;
            while(st.hasMoreTokens()){
                int cur =Integer.parseInt(st.nextToken());
                arr[i][col]=cur+prev;
                prev=arr[i][col++];
            }
        }
        while (tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            int total =0;
            for(int i=s;i<=e;i++){
                total += arr[i][max]-arr[i][min-1];
            }
            bw.write(total+"\n");
        }

        bw.flush();
        bw.close();
    }
     */
    /** 행/ 열 누적합?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<arr.length;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<arr.length;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j]
                        + dp[i-1][j]
                        + dp[i][j-1]
                        - dp[i-1][j-1];
            }
        }
        while (tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            bw.write(total+"\n");
        }

        bw.flush();
        bw.close();
    }
     */
    /** 행 누적합 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st  = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j]= arr[i][j-1]+Integer.parseInt(st.nextToken());
            }
        }
        while (m-- >0){
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total= 0;
            for(int i = x1; i <= x2; i++){
                total += arr[i][y2]-arr[i][y1-1];
            }
            bw.write(total+"\n");
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = arr[1][i];
            dp[i][1] = arr[i][1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j-1] -dp[i-1][j-1]+arr[i][j];
            }
        }

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int res = dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];

            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }

}
