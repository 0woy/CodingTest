package Data_Structure;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        int i=0;
        while(i<testcase) {
            LinkedList<Integer> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");

            int pcout = Integer.parseInt(st.nextToken());   // 총 문서 개수
            int pos = Integer.parseInt(st.nextToken());     // 찾고자 하는 문서의 큐 idx
            int count = 1;    // 찾는 문서의 인쇄 번째

            st = new StringTokenizer(br.readLine()," ");
            // 큐의 초기 상태
            for(int k=0;k<pcout;k++){
                que.addLast(Integer.parseInt(st.nextToken()));
            }

            int maximum = 9;
            while(!que.isEmpty()) {

                int max = que.get(0); // 최우선순위 값
                int max_idx = 0;        // 최 우선순위 인덱스

                // 현재 큐에서 최우선순위를 가진 문서 인덱스 찾기
                for (int m = 1; m < que.size(); m++) {
                    if (max < que.get(m)) {
                        max = que.get(m);
                        max_idx = m;
                        if(max == maximum) break;
                    } else continue;
                }
                if(max < maximum) maximum =max;

                if(max_idx == pos){
                    sb.append(count+"\n");
                    break;
                }

                    que.remove(max_idx); // 최우선순위 문서 제거
                    if(max_idx>0) {
                        boolean isposChange = false;
                        // 제거된 최우선순위 앞 문서들 차례대로 맨 뒤로 이동
                        for (int m = 0; m < max_idx; m++) {
                            if (m == pos && !isposChange) {
                                pos = que.size() - max_idx + pos;
                                isposChange = true;
                            }
                            que.addLast(que.removeFirst());  // 맨 앞 수 뒤로 이동
                        }
                        if(!isposChange)
                            pos = pos - max_idx-1;
                    }
                    else pos-=1;
                    count++;
            }
            i++;    // 반복
        }
        System.out.print(sb);
    }
}
