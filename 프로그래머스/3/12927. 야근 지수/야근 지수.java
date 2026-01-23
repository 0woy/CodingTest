import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        int total = Arrays.stream(works).sum();
        if(total <= n) return 0;
        Queue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        for(int v: works) pq.offer(v);
        
        while(n>0){
            pq.offer(pq.poll()-1);
            n--;
        }
        long answer = 0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}