import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);   // 요청시간 정렬
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> a[1]-b[1]); // 소요 시간 정렬
        
        int turnAroundTime =0;
        int curTime=0;
        int jobIdx =0;
        int count=0;
        int n= jobs.length;
        
        while(count < n){
            while(jobIdx < n && jobs[jobIdx][0] <= curTime){
                pq.offer(jobs[jobIdx++]);
            }
            if(pq.isEmpty()){
                curTime = jobs[jobIdx][0];   // 시간 점프
            }else{
                int [] job = pq.poll();
                turnAroundTime += curTime+job[1]-job[0];
                
                curTime += job[1];  // 현재 시간 update
                count++;
            }
        }
            return turnAroundTime/n;
    }
}