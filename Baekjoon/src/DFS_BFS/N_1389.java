package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1389 {
    static Map<Integer, List<Integer>> connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new HashMap<>();
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            List<Integer> tmp = connect.getOrDefault(i, new ArrayList<>());
            tmp.add(j);
            connect.put(i, tmp);

            tmp = connect.getOrDefault(j, new ArrayList<>());
            tmp.add(i);
            connect.put(j, tmp);
        }
        int [] distanceSum = new int[n+1];
        for(int i=1;i<=n;i++){
            distanceSum[i] = bfs(i,n);
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=1;i<=n;i++){
            if(distanceSum[i]<min){
                min = distanceSum[i];
                res = i;
            }
        }
        System.out.println(res);
    }
    public static int bfs(int start, int n){
        Queue<Integer> que = new ArrayDeque<>();
        boolean [] visited =new boolean[n+1];
        int [] distance =new int[n+1];

        que.add(start);
        visited[start]=true;

        while(!que.isEmpty()){
            int size =que.size();
            int cur = que.poll();
            for(int v: connect.get(cur)){
                if(!visited[v]){
                    visited[v] = true;
                    distance[v] = distance[cur]+1;
                    que.add(v);
                }
            }
        }
        int total = 0;
        for(int s: distance){
            total+=s;
        }
        return  total;
    }
}
