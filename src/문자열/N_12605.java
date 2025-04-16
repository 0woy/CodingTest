package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc =Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++){
            String[] tokens = br.readLine().split(" ");
             sb.append("Case #").append(i).append(": ");
             for(int j = tokens.length-1;j>=0;j--){
                 sb.append(tokens[j]).append(" ");
             }
             sb.append("\n");
        }
        System.out.println(sb);
    }
}
