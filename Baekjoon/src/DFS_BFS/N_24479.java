package DFS_BFS;

import java.io.*;
import java.util.*;

public class N_24479 {
    /** Solve with Priority Queue
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
     */
    static List<Integer>[] adj;
    static int[]visited;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new int[N + 1];
        idx=1;
        while (M -- >0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(adj[s]==null)
                adj[s]= new  ArrayList<>();
            if(adj[e]==null)
                adj[e] = new ArrayList<>();

            adj[s].add(e);
            adj[e].add(s);
        }
        for(int i=0;i<adj.length;i++){
            if(adj[i]!=null){
                Collections.sort(adj[i]);
            }
        }

        dfs(start);
        for(int i = 1; i <= N; i++){
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int cur){
        visited[cur] = idx++;
        if(adj[cur]==null){return;}

        for(int next: adj[cur]){
            if(visited[next] == 0){
                dfs(next);
            }
        }
    }

}
