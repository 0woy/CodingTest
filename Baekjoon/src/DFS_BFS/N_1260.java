package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1260 {
    /** Wrong
    public static boolean[] visited;
     public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        int n =Integer.parseInt(st.nextToken());
        int e =Integer.parseInt(st.nextToken());
        int start =Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        while(e -- >0){
            st =new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> kq = map.getOrDefault(key, new PriorityQueue<>());
            PriorityQueue<Integer> vq = map.getOrDefault(val, new PriorityQueue<>());
            kq.add(val);
            vq.add(key);

            map.put(key, kq);
            map.put(val, vq);
        }
        StringBuilder sb = new StringBuilder();
        dfs(map,start,sb);
         System.out.println(sb.toString());
        Arrays.fill(visited, false);
        System.out.println(bfs(map, start));
    }
    public static void dfs(Map<Integer, PriorityQueue<Integer>> map, int start, StringBuilder sb){
         sb.append(start+" ");
         if(map.get(start)==null){
             visited[start]=true;
             return;
         }
         for(int v: map.get(start)){
             visited[start] = true;
             if(!visited[v])
                dfs(map, v,sb);
         }
    }
    public static String bfs(Map<Integer, PriorityQueue<Integer>> map, int start){
        StringBuilder sb= new StringBuilder();
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int next = que.poll();
            sb.append(next+" ");
            if(map.getOrDefault(next, new PriorityQueue<>()).isEmpty()){ continue;}
            for(int v: map.get(next)){
                if(!visited[v]){
                    que.add(v);
                    visited[v]=true;
                }
            }
        }

        return sb.toString();
    }
     */
    static boolean [] visited;
    static Map<Integer, PriorityQueue<Integer>> map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        visited = new boolean[n+1];
        while(e-- >0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> tmp = map.getOrDefault(a, new PriorityQueue<>());
            tmp.add(b);
            map.put(a,tmp);
            tmp = map.getOrDefault(b, new PriorityQueue<>());
            tmp.add(a);
            map.put(b,tmp);
        }

        sb = new StringBuilder();
        dfs(start);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(start);

        System.out.println(sb.toString());
    }

    public static void dfs(int start){
        visited[start] = true;
        sb.append(start+" ");

        if(map.get(start)== null){
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>( map.get(start));
        while(!pq.isEmpty()){
            int v = pq.poll();
            if(visited[v]){
                continue;
            }
            dfs(v);
        }
    }

    public static void bfs(int start){
        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int v = que.poll();
            sb.append(v+" ");

            PriorityQueue<Integer> pq = map.getOrDefault(v, new PriorityQueue<>());
            while(!pq.isEmpty()){
                int n = pq.poll();
                if(!visited[n]){
                    que.add(n);
                    visited[n]=true;
                }
            }
        }
    }
}


