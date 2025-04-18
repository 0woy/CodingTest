package Stack;

import java.io.*;
import java.util.Stack;

public class N_9012 {
    public static boolean isVPS(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int tc= Integer.parseInt(br.readLine());
        StringBuilder sb;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(tc>0){
            sb = new StringBuilder(br.readLine());
            if(isVPS(sb.toString())){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
            sb.setLength(0);
            tc--;
        }
        bw.flush();
        bw.close();
    }
}
