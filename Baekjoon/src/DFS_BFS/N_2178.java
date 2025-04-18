package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2178 {
    static boolean[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        maze = new boolean[row][col];

        for(int i=0;i<row;i++){
            String str = br.readLine();
            int j=0;
            for(char c: str.toCharArray()){
                maze[i][j++] = (c=='1')?true:false;
            }
        }
        int result = bfs();
        System.out.println(result);
    }
    public static int bfs(){
        Queue<int []> que = new ArrayDeque<>();
        int [] dx =new int[]{0,1,0,-1};
        int [] dy =new int[]{1,0,-1,0};
        que.add(new int[]{0,0});
        maze[0][0]=false;
        int count =1;
        while(!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx== maze.length - 1 && ny == maze[0].length - 1) {
                        return count+1;
                    }
                    if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                        continue;
                    }
                    if (maze[nx][ny]) {   // 이동 가능한 경우
                        maze[nx][ny] = false;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }
        return count;
    }
}
