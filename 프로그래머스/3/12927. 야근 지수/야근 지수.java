import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long total = Arrays.stream(works)
            .sum();
        if(total <=n) return 0;
        if(works.length==1) return Math.max(works[0]-n,0);
        PriorityQueue<Integer> pq 
            = new PriorityQueue<>(Collections.reverseOrder());        
        for(int v: works) {
            pq.offer(v);
        }                        
        while(n >0){
            pq.offer(pq.poll()-1);
            n--;
        }        
        total =0;
        while(!pq.isEmpty()){
            total+= Math.pow(pq.poll(),2);
        }
        return total;
    }
}