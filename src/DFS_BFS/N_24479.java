package DFS_BFS;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_24479 {
    static Map<Integer, PriorityQueue<Integer>> map;
    static int [] visited;
    static int idx;
    public static void insertMap(int s, int e){
        PriorityQueue<Integer> pq =map.get(s);
        pq.add(e);
        map.put(s,pq);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new int[N+1];
        idx=1;

        for(int i=1;i<=N;i++){
            map.put(i, new PriorityQueue<>());
        }

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            insertMap(a,b);
            insertMap(b,a);
        }
        dfs(start);
        for(int i=1;i<visited.length;i++){
            bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int cur){
        if(visited[cur]!=0){return;}
        PriorityQueue<Integer> pq =map.get(cur);
        visited[cur]=idx++;
        while (!pq.isEmpty()){
            int next= pq.poll();
            if(visited[next]==0){
                dfs(next);
            }
        }
    }
}
