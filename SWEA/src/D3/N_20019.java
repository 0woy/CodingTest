package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_20019 {
    static StringBuilder sb;
    public static boolean isPalindrome(String s){
        int len = s.length()/2;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }

        int idx = 0;
        for(int i=len+1;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-idx-1)){
                return false;
            }
        }

        for(int i=0;i<len;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb =  new StringBuilder();
        int tc =Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            String s = br.readLine();
            boolean res = isPalindrome(s);
            if(res){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
