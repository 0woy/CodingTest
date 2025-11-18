import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            int n  = Integer.parseInt(br.readLine());
            int [] price = new int[n];
            int i=0;
            for(String v: br.readLine().split(" ")){
                price[i++] = Integer.parseInt(v);
            }
            long res = calc(price);
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
    public static long calc(int [] prices){
        long max = prices[prices.length-1];
        long minus = 0;
        long plus =0;
        long count =0;
        for(int i=prices.length-2 ; i>=0;i--){
            if(max < prices[i]){
                plus += count*max - minus;
                count = 0;
                minus=0;
                max = prices[i];
                continue;
            }
            minus += prices[i];
            count++;
        }
        plus += count*max - minus;
        return plus;
    }
}
