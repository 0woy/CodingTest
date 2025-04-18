import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_17626 {
    /** WRONG 46%, 반례: 27532
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int min = 5;
        int msqrt = (int)Math.sqrt(n);
        int len = msqrt;

        for(int i=0;i<len;i++){
            int count =0;
            int tmp = n;
            int sqrt = msqrt--;
            while (tmp > 0){
                tmp -=Math.pow(sqrt,2);
                sqrt = (int) Math.sqrt(tmp);
                count++;
            }
            min = Math.min(count,min);
        }
        System.out.println(min);

    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[n]);
    }
}
