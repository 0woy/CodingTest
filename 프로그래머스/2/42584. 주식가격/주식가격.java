import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Deque<int[]> stack = new ArrayDeque<>();
        int n = prices.length;
        int [] answer = new int[n];
        
        for(int i=0;i<n;i++){
            int val = prices[i];
            while(!stack.isEmpty() && stack.peek()[0] > val){
                int [] prev = stack.poll();
                answer[prev[1]] = i-prev[1]; // 기간
            }
            stack.addFirst(new int[]{val, i});
        }
        
        while(!stack.isEmpty()){
            int [] stock = stack.poll();
            int priod = n-stock[1]-1;
            answer[stock[1]] = priod;
        }
        return answer;
    }
}

/**
초 단위로 기록, 
stack의 맨 위 > 현재 (가격 하락)
[val, idx] = stack.pop(), 떨어지지 않은 기간: cur-idx (4)
스택에 남아있는 것 : 끝까지 떨어지지 않은 주식
결과= 배열.length -idx-1 (5-0-1) =4;
*/