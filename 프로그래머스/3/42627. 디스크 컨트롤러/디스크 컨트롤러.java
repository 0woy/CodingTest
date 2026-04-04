import java.util.*;
class Solution {
    static class Work{
        int reqt, idx, ndt;
        public Work(int i, int r, int u){
            reqt =r;
            idx=i;
            ndt =u;
        }

    }
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Work[] works = new Work[n];
        for(int i=0;i<n;i++){
            works[i] = new Work(i, jobs[i][0],jobs[i][1]);
        }
        Arrays.sort(works, (a,b)->a.reqt-b.reqt);

        PriorityQueue<Work> pq = new PriorityQueue<>((a,b) ->{
            if(a.ndt == b.ndt){
                if(a.reqt==b.reqt) return a.idx-b.idx;
                return a.reqt - b.reqt;
            }   
            return a.ndt -b.ndt;
        });
        
        int time =works[0].reqt;
        int i =1;
        int tt =0;
        pq.offer(works[0]);
        while(i<n || !pq.isEmpty()){
            while(i<n && time >= works[i].reqt) pq.offer(works[i++]);
            if(!pq.isEmpty()){
                Work cur = pq.poll();
                tt += time+cur.ndt-cur.reqt;
                time = time+cur.ndt;
            }else{
                time =works[i].reqt;
            }
        }
        
        return tt/n;
    }
}
/**
reqt, ust
priority: ust, reqt, idx asc
endt == reqt,
1. add que (reqt)
2. priority calc

tt = reqt~endt = endt-reqt
job: idx, reqt, ndt

pq add: reqt, ndt, idx;
init time = pq.poll.reqt

time = endt
while(time = jobs.reqt) pq.add(job)
calc

*/