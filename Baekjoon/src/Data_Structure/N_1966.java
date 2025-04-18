package Data_Structure;

import com.sun.source.doctree.StartElementTree;

import java.io.*;
import java.util.*;
import java.util.Queue;
public class N_1966 {
    /** Previous Solve
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

                        // 제거된 최우선순위 앞 문서들 차례대로 맨 뒤로 이동
                        for (int m = 0; m < max_idx; m++) {
                            que.addLast(que.removeFirst());  // 맨 앞 수 뒤로 이동
                        }
                        if (pos < max_idx) {    pos = que.size() - max_idx + pos;   }
                        else {  pos = pos - max_idx - 1;  }
                    }

                    else pos-=1;
                    count++;
            }
            i++;    // 반복
        }
        System.out.print(sb);
    }
     */
    static BufferedReader br;
    static StringTokenizer st;
    public static class Pair{
        int pos, priority;
        Pair(int pos, int priority){
            this.pos=pos;
            this.priority=priority;
        }
    }
    public static void main(String[] args) throws  IOException{
        Queue<Pair> que = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc>0){
            st = new StringTokenizer(br.readLine());
            int len =Integer.parseInt(st.nextToken());
            int goal =Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2-o1;
                        }
                    }
            );
            st = new StringTokenizer(br.readLine());
            int idx =0;
            while(st.hasMoreTokens()){
                int prior = Integer.parseInt(st.nextToken());
                    pq.add(prior);
                que.add(new Pair(idx++, prior));
            }
            int count = 0;
            int max = 0;
            boolean isContinue = true;
            while(!que.isEmpty()&&isContinue){
                if(!pq.isEmpty())
                    max = pq.poll();
                int clen = que.size();
                for(int i=0;i<clen;i++){
                    if(que.peek().priority >= max){
                        count++;
                        if(que.poll().pos == goal){
                            bw.write(count+"\n");
                            isContinue=false;
                        }
                        break;

                    }else{
                        que.add(que.poll());
                    }
                }
            }
            que.clear();
            pq.clear();
            tc--;
        }
        bw.flush();
        bw.close();

    }
}
