package KB.week01;

import java.util.*;
class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int idx =0;

        for(int i=0;i<d.length;i++){
            if(budget - d[i] >=0){
                budget -= d[i];
                answer++;
            }else{
                return answer;
            }
        }
        return answer;
    }
}