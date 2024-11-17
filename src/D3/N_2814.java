package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_2814 {
    static Map<Integer, List<Integer>> map;
    static boolean [] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            map = new HashMap<>();
            max = 0;

            st = new StringTokenizer(br.readLine());
            int n =Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());
            visited = new boolean[n+1];
            while(m -- > 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                List<Integer> tmp = map.getOrDefault(a, new ArrayList<>());
                tmp.add(b);
                map.put(a,tmp);
                tmp = map.getOrDefault(b, new ArrayList<>());
                tmp.add(a);
                map.put(b,tmp);
            }
            max = 0;
            for(int i=1;i<=n;i++){
                visited =new  boolean [n+1];
                visited[i]=true;
                dfs(i,1);
            }
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int start, int len){
            max = Math.max(max, len);
            if(map.get(start) == null){
                return;
            }
            for(int v: map.get(start)){
                if(!visited[v]){
                    visited[v] = true;
                    dfs(v,len+1);
                    visited[v]=false;
            }
        }
    }
    /**
    public static int bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        int count =1;
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
            int key =que.poll();
            if(!map.containsKey(key)){continue;}
            for(int v: map.get(key)){
                if(!visited[v]) {
                    visited[v]=true;
                    que.add(v);
                    count++;
                }
            }
        }
        return count;
    }
     */
}
