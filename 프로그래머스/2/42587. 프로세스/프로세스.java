import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            pq.add(priorities[i]); // 우선순위 삽입
            que.add(i); // idx 삽입
        }
        int num = 1;
        while(!que.isEmpty()){
            int curIdx = que.poll();
            int pr = pq.peek();
            if(priorities[curIdx]==pr){
                if(curIdx == location) return num;
                else {
                 pq.poll();
                 num++;
                }
            }
            
            que.offer(curIdx);                                   
        }         
        
        return num;
    }
}