import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int v: scoville) pq.offer(v);
            
        int count = 0;
        while(!pq.isEmpty()){
            int s1 = pq.poll();
            if(s1 >= K) return count;
            if(pq.isEmpty()) return -1;
            int s2 = pq.poll();
            int sum = s1+(s2*2);
            pq.offer(sum);
            count++;
            
        }
         return -1;
    }
}

/**
K이상의 숫자로 만들기
sum : a+(b*2)
모든 숫자가 k 이상, 최소 횟수 return
 n = 백만
 k>10억 9*2 18+9 = long?
 k이상으로 만들 수 없는 경우 -1
 
 pq로 작은 값이 먼저 나오게'
 while(!pq.isEmpty()){
    int s1 = pq.poll();
    if(s1 >= k) return count;
    
    int s2 = pq.poll();
    int sum = s1+(s2*2);
    pq.offer(sum);
 }
 return -1;
*/