package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7576 {
    /** Complex Code
    static int [][] arr;
    static final int [] dx = new int[]{0,1,0,-1};
    static final int [] dy = new int[]{1,0,-1,0};
    static Queue<int []> que;
    static int days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        que= new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        int yetCount = 0;
        for(int i=0;i<arr.length;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    que.add(new int[]{i,j});
                }else if(arr[i][j]==0){
                    yetCount++;
                }
                j++;
            }
        }
        if (yetCount==0){
            System.out.println(0);
            return;
        }
        days=-1;

        while (!que.isEmpty() && yetCount>0){
            yetCount = bfs(yetCount);
        }
        if(yetCount>0){
            System.out.println(-1);
        }else{
            System.out.println(days);
        }

    }
    public static int bfs(int yetCount){
        while (!que.isEmpty()) {
            days++;
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                int cx = cur[0];
                int cy = cur[1];
                if (arr[cx][cy] == 2) {
                    continue;
                }
                arr[cx][cy] = 2;    // 방문 처리

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length || arr[nx][ny] == -1) {
                        continue;
                    }
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        que.add(new int[]{nx, ny});
                        yetCount--;
                    }
                }
            }
        }
        return yetCount;
    }
     */
    static final int [] dx = new int[]{0,1,0,-1};
    static final int [] dy = new int[]{1,0,-1,0};
    static int[][] tomatoes;

    static class Position{
        int x, y,day;

        public Position(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Position> que = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tomatoes = new int[m][n];
        int yetCount =0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j]==1){
                    que.offer(new Position(i,j,0));
                }else if(tomatoes[i][j]==0){
                    yetCount++;
                }
                j++;
            }
        }

        int maxDays = 0;
        while (!que.isEmpty()){
            Position cur = que.poll();
            maxDays = Math.max(cur.day, maxDays);
            for(int d=0;d<4;d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];

                if(nx < 0 || ny<0 || nx>=tomatoes.length|| ny>=tomatoes[0].length){
                    continue;
                }
                if(tomatoes[nx][ny]==0){
                    tomatoes[nx][ny]=1;
                    yetCount--;
                    que.offer(new Position(nx,ny,cur.day+1));
                }
            }
        }
        System.out.println(yetCount==0?maxDays:-1);

    }
}
