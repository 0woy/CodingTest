package DFS_BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_4963 {
    static int[][] map;
    static int[] dx = { -1,-1,-1,0,0,1,1,1};
    static int[] dy = { -1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
             st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            Queue<int[]> land = new ArrayDeque<>();
            map = new int[h][w];
            for(int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1) land.add(new int[] {i,j});
                }
            }
            int count = 0;
            while (!land.isEmpty()) {
                int [] next = land.poll();
                if(map[next[0]][next[11]]==1){
                    count++;
                    bfs(next[0],next[1]);
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void bfs(int r, int c) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {r,c});
        while (!que.isEmpty()){
            int[] cur = que.poll();
            map[cur[0]][cur[1]] = -1;   // visited
            for(int d=0 ;d<8;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx<0 ||ny<0 || nx>=map.length || ny>=map[0].length) continue;
                if(map[nx][ny]==1) {
                    map[nx][ny] = -1;
                    que.add(new int[] {nx,ny});
                }
            }
        }

    }
}
