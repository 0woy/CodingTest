package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(start==end){
            System.out.println(0);
            return;
        }
        int [] map = new int[100001];

        System.out.println(bfs(map, start, end));
    }
    public static int bfs(int[] map, int start, int end){
        Queue<Integer> que = new ArrayDeque<>();
        int [] move = new int[]{1,-1,2};

        que.add(start);
        int count =0;
        map[start] =count;
        while(!que.isEmpty()){
            int cur =que.poll();
            for(int i=0;i<3;i++){
                int nx = (i==2)?cur*move[i]:cur+move[i];
                if(nx < 0 || nx>=map.length || map[nx]>0){
                    continue;
                }

                map[nx]=map[cur]+1;
                if(nx == end){
                    return map[nx];
                }
                que.add(nx);
            }
        }

        return -1;
    }
}
