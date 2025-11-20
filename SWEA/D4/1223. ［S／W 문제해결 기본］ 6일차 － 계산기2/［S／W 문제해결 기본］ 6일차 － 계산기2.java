import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#"+t+" ");
            stack = new Stack<>();
            br.readLine();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (Character.isDigit(cur)) {
                    stack.push(cur - '0');
                    continue;
                }
                if (cur == '*') {
                    int prev = stack.pop();
                    int next = str.charAt(i + 1) -'0' ;
                    stack.push(prev * next);
                    i++;
                }
            }
            int total =0;
            while (!stack.isEmpty()) {
                total += stack.pop();
            }
            sb.append(total+"\n");
        }
        System.out.println(sb.toString());
    }
}
