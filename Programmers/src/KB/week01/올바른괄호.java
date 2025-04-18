package KB.week01;
import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){return false;}
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
