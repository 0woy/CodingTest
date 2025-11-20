import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        start:
        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            br.readLine();

            String str = br.readLine();
            stack = new Stack<>();
            int isCorrect = 1;
            for (char ch : str.toCharArray()) {
                if(isOpen(ch)){
                    stack.push(ch);
                }else{
                    char open = stack.pop();
                    if(!isPair(open, ch)){
                        isCorrect = 0;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) isCorrect =0;
            sb.append(isCorrect+"\n");
        }
        System.out.println(sb);
    }

    static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '<' && close == '>');
    }
}
