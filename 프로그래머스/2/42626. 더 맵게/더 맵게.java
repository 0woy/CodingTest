import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int v: scoville){pq.add(v);}
        int count =0;
        while(pq.size()>1 && pq.peek()< K){
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b*2);
            count++;
        }
        if(!pq.isEmpty() &&  pq.peek() >= K) return count;
        
        return -1;
    }
}