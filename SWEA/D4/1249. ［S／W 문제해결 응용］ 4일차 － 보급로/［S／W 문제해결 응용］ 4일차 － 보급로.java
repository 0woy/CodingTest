import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    final static int [] dx = {0,1,0,-1};
    final static int [] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (char ch : br.readLine().toCharArray()) {
                    map[i][j++] = ch - '0';
                }
            }
            int res = bfs(map);
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int[][] map) {
        int n = map.length;
        Queue<int []> que = new ArrayDeque<>();
        int [][] visited = new int[n][n];
        for(int [] v: visited){
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        que.offer(new int[]{0,0,0});
        visited[0][0] = 0;
        while (!que.isEmpty()){
            int [] cur = que.poll();
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(nx < 0 || ny < 0 || nx >=n || ny >=n )continue;

                // 방문하지 않았거나, 더 최단 거리가 있는 경우
                if(visited[nx][ny] == Integer.MAX_VALUE || cur[2]+map[nx][ny] < visited[nx][ny]){
                    visited[nx][ny] = cur[2]+map[nx][ny];
                    que.offer(new int[]{nx,ny, visited[nx][ny]});
                }
            }
        }
        return visited[n-1][n-1];

    }
}
