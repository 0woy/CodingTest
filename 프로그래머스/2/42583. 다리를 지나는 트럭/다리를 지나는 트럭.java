import java.util.*;

class Solution {
public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> que = new ArrayDeque<>();
        int time = 0;
        int totalW = 0;
        int truckIdx = 0;
    
        while(truckIdx < truck_weights.length || !que.isEmpty()){
            time++; // 시간은 기본적으로 흐름
            if(!que.isEmpty() && que.peek()[1]==time){
                totalW-=que.poll()[0];
            }
            
            // 2. 새 트럭이 들어올 수 있는지 확인
            if(truckIdx < truck_weights.length){
                if(totalW+truck_weights[truckIdx] <=weight){
                    if(que.size() < bridge_length){
                        int arriveTime = time+bridge_length;
                        que.offer(new int[]{truck_weights[truckIdx], arriveTime});
                        totalW+=truck_weights[truckIdx];
                        truckIdx++;
                    }
                }
            }
                       
        }
        return time;
    }
}