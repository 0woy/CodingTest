package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=10;t++){
            sb.append("#"+t+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int [] height = new int[n];
            st = new StringTokenizer(br.readLine());
            int total = 0;

            for(int i=0;i<n;i++){
                height[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2;i<n-2;i++){
                int cur = height[i];
                // 나보다 높은 애가 하나라도 있으면 안 됨
                if(height[i-1]>=cur|| height[i-2]>=cur||
                height[i+1]>=cur||height[i+2]>=cur){
                    continue;
                }
                else{
                    int [] tmp = Arrays.copyOfRange(height,i-2, i+3);
                    Arrays.sort(tmp);
                    int second = tmp[tmp.length-2];
                    total += cur-second;
                }
            }

            sb.append(total+"\n");
        }

        System.out.print(sb.toString());
    }
}
