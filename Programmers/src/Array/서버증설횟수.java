package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> server = new ArrayList<>();

        for(int i=0;i<players.length;i++){
            if(server.contains(i)){
                server.removeAll(Collections.singleton(Integer.valueOf(i)));
            }

            int p = players[i];
            if(p >= m){
                int avail = server.size()*m; // 현재 가용 인원
                int remain = (p-avail)/m;
                while(remain > 0){
                    server.add(i+k);
                    remain--;
                    answer++;
                }
            }
        }
        return answer;
    }
}
