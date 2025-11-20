import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> que =new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            pq.offer(priorities[i]);
            que.offer(i);
        }
        
        int count =1;
        while(!que.isEmpty()){
            int p = pq.peek();
            int cur = que.poll();
            if(priorities[cur]!=p) que.offer(cur);
            else{
                if(cur == location){ return count;}
                else pq.poll();            
                count++;
                
            }
        }
        return count;
    }
}