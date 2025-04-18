package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_11724 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        Map<Integer, List<Integer>> map = new HashMap<>();
        while(e-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> tmp = map.getOrDefault(a, new ArrayList<>());
            tmp.add(b);
            map.put(a,tmp);

            tmp = map.getOrDefault(b,new ArrayList<>());
            tmp.add(a);
            map.put(b,tmp);
        }

        int res =0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                res++;
                dfs(map, i);
            }
        }
        System.out.print(res);
    }

    public static void dfs(Map<Integer, List<Integer>> map, int start){
        visited[start] = true;
        if(map.get(start)== null){
            return;
        }
        for(int v: map.get(start)){
            if(!visited[v]){
                dfs(map, v);
            }
        }
    }
}
