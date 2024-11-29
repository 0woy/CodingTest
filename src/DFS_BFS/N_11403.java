package DFS_BFS;

import java.io.*;
import java.util.*;

public class N_11403 {
    static int [][] res;
    static Map<Integer, List<Integer>> map;
    static boolean [] visited;
    /** TimeOut
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        visited = new boolean[n];
        res = new int[n][n];

        for(int i=0;i<n;i++){
            List<Integer>tmp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int j =0;
            while(st.hasMoreTokens()){
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1){
                    tmp.add(j);
                }
                j++;
            }
            map.put(i, tmp);
        }
        for(int i=0;i<n;i++){
            dfs(i, i);
        }
        for(int [] row: res){
            for(int v: row){
                bw.write(v+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, int cur){
        if(map.get(cur)==null){
            return;
        }
        for(int next: map.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                res[start][next] = 1;
                dfs(start, next);
                visited[next]=false;
            }
        }
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        res = new int[n][n];

        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) {
                    tmp.add(j);
                }
                j++;
            }
            map.put(i, tmp);
        }
        for(int i=0;i<n;i++){
            visited = new boolean[n];
            check(i);
        }
        for(int [] row : res){
            for(int v: row){
                bw.write(v+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void check(int start){
        Set<Integer> valuse = new HashSet<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        while(!que.isEmpty()){
            int cur = que.poll();
            if(map.get(cur)== null){
                continue;
            }
            for(int v: map.get(cur)){
                if(!visited[v]){
                    visited[v] = true;
                    que.add(v);
                    res[start][v] = 1;
                }
            }
        }
    }
}
