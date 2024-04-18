package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for(int i=1;i<=testcase;i++){
            sb.append("#"+i+" ");
            int n = Integer.parseInt(br.readLine());
            int sum=0;
            if(n%2!=0)
                sum= n-n/2;
            else
                sum = n/2*-1;
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
