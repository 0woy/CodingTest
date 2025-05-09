package DFS_BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 보물지도 {
    static boolean [][][] visited;
    final static int[] dx = {0,1,0,-1,0,2,0,-2};
    final static int[] dy = {1,0,-1,0,2,0,-2,0};
    public static int solution(int n, int m, int[][] hole) {
        boolean [][] trap = new boolean[n+1][m+1];
        visited=new boolean[n+1][m+1][2];
        for(int [] hp : hole) {
            trap[hp[0]][hp[1]] =true;
        }
        int res = bfs(n,m,trap);
        System.out.println(res);
        return res;
    }
    public static int bfs(int n, int m, boolean [][]trap) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{1,1,0,0}); // x, y, shoe, dist
        visited[1][1][0]=true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int x=cur[0],y=cur[1], jumped=cur[2], dist=cur[3];

            for(int d = 0; d < ((jumped==1)?4:8); d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                int nj = (jumped==1)?1:d/4; // 이전에 점프하면 1, 아니면 0또는 1

                if(nx<1 || ny<1 || nx>n || ny > m){
                    continue;
                }
                if(!visited[nx][ny][nj] && !trap[nx][ny]){
                    if(nx == n && ny == m){
                        return dist+1;
                    }
                    que.offer(new int[]{nx,ny,nj,dist+1});
                    visited[nx][ny][nj]=true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        solution(4, 4, new int[][]{
                {2,3},
                {3,3}
        });
    }
}
