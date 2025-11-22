import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++){
            String cur =  String.valueOf(i);
            int count =0;
            for(char ch : cur.toCharArray()){
                if(ch == '3' || ch=='6' || ch=='9'){
                    count++;
                }
            }
            if(count > 0) {for(int c=0;c<count;c++) sb.append("-");}
            else sb.append(cur);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
