package KB.week01;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<prices.length;i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i-idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = answer.length - idx-1;
        }
        return answer;
    }
}
