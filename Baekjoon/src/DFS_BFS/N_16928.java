package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_16928 {
    static class Position{
        int idx, dice;
        public Position(int idx, int dice) {
            this.idx = idx;
            this.dice = dice;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] maze = new int[101];
        StringTokenizer st =new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        while (ladder-- >0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            maze[s]=e;
        }
        while (snake-- >0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            maze[s]=e;
        }

        Queue<Position> que = new ArrayDeque<>();
        que.offer(new Position(1,0));

        while (!que.isEmpty()){
            Position cur =que.poll();
            for(int i=1;i<=6;i++){
                int next = cur.idx+i;
                if(next>100 || maze[next]==-1){
                    continue;
                }
                if(next==100){
                    System.out.println(cur.dice+1);
                    return;
                }

                que.offer(maze[next]==0
                        ? new Position(next, cur.dice+1)
                        : new Position(maze[next], cur.dice+1));

                maze[next]=-1;
            }
        }
    }
}
