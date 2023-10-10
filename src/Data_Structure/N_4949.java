package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            boolean clear = true;
            if (str.charAt(0) == '.') break;

            Stack<Character> stack = new Stack<>();
            for (char v : str.toCharArray()
            ) {
                if((v>=65 && v <=90)||(v>=97 && v<=122))
                    continue;
                if (v == '(' || v == '[')
                    stack.push(v);
                else if (v == ')') {
                    if (stack.isEmpty() || stack.pop() != '('){
                        sb.append("no\n");
                        clear = false;
                        break;
                    }
                } else if (v == ']') {
                    if (stack.isEmpty() || stack.pop() != '['){
                        sb.append("no\n");
                        clear = false;
                        break;
                    }
                }
            }
            if (clear) {
                if (stack.isEmpty())
                    sb.append("yes\n");
                else
                    sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}
