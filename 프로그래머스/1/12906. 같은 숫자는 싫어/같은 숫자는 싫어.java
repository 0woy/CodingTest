import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int v: arr){
            if(stack.isEmpty() || stack.peekLast()!=v){
                stack.addLast(v);
            }
        }
        int [] answer = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            answer[i++] = stack.removeFirst();
        }
        
        return answer;
    }
}
/**
배열에서 연속적으로 나타나는 숫자 제거, 남은 수 return
n = 백만
숫자: 0~9
stack -> 비어있거나 top과 숫자가 다르면 push
*/