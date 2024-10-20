package Stack;

import java.io.*;
import java.util.Stack;

public class N_4949 {
    public static boolean isOpen(char ch){
        return ch=='(' || ch =='[';
    }
    public static boolean isMatched(char open, char close){
        return (open == '(' && close==')') ||
                (open=='['&& close==']');
    }
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        while(true){
            stack.clear();
            String cur = br.readLine();
            if(cur.equals(".")){
                bw.flush();
                bw.close();
                return;
            }
            cur = cur.replaceAll("[^\\[\\]\\(\\)]","");
            if(cur.length()==0){
                bw.write("yes\n");
                continue;
            }
            boolean isFinish = true;
            for(char ch : cur.toCharArray()){
                if(isOpen(ch)){
                    stack.push(ch);
                }
                else{
                    if(stack.isEmpty() || !isMatched(stack.pop(), ch)){
                        isFinish = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                isFinish=false;
            }
            if(isFinish){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }
    }
}
