import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> que = new ArrayDeque<>();
        int time =0;
        int totalW = 0;
        int idx=0;
        while(idx < truck_weights.length || !que.isEmpty()){
            time++;                        
                
                if(!que.isEmpty() && que.peek()[1] == time){
                    totalW -=que.poll()[0];
                }
            if(idx < truck_weights.length && truck_weights[idx]+totalW<=weight){
                    if(que.size()<bridge_length){
                        int w =  truck_weights[idx++];
                        totalW+=w;
                        int arrivalTime = time+bridge_length;
                        que.offer(new int[]{w, arrivalTime});
                    }
                }
        }
        return time;
    }
}