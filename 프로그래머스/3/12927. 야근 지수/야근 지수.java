import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = Arrays.stream(works).sum();
        if(answer <= n) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        Collections.reverseOrder());
        
        for(int v: works){
            pq.offer(v);
        }
        
        
        while(n > 0){
            pq.offer(pq.poll()-1);
            n--;
        }
        answer =0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}