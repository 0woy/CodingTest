package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class N_2468 {
    /** Wrong Answer
    static class Point{
        int height;
        boolean visited;

        public Point(int height) {
            this.height = height;
            this.visited = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N= Integer.parseInt(br.readLine());
        Point[][] ground = new Point[N][N];
        Set<Integer> rain = new HashSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                int height = Integer.parseInt(st.nextToken());
                rain.add(height);
                ground[i][j++] = new Point(height);
            }
        }
        List<Integer> tmp = new ArrayList<>(rain);

        int max =0;
        while (!tmp.isEmpty()){
            int min = tmp.remove(0);
            int [] start =null;
            int count =0;
            initGround(ground);

            for(int i=0;i<ground.length;i++){
                for(int j=0;j<ground[0].length;j++){
                    if(!ground[i][j].visited&&ground[i][j].height>min&&start==null){
                        bfs(ground, i,j,min);
                        count++;
                    }
                }
            }
            max = Math.max(count,max);
        }
        System.out.println(max);

    }

    public static void initGround(Point[][] ground){
        for(Point[] points: ground){
            for(Point p: points){
                p.visited=false;
            }
        }
    }

    public static void bfs(Point[][] ground, int r, int c, int rain){
        Queue<int[]> que = new ArrayDeque<>();
        int [] dx = new int[]{0,0,1,-1};
        int [] dy = new int[]{1,-1,0,0};

        que.offer(new int[]{r,c});
        ground[r][c].visited=true;
        while (!que.isEmpty()){
            int [] cur = que.poll();
            int x= cur[0];
            int y = cur[1];
            for(int d=0;d<4;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx<0 || ny<0 || nx>=ground.length || ny>=ground.length){
                    continue;
                }

                if(ground[nx][ny].height<=rain || ground[nx][ny].visited){
                    continue;
                }

                ground[nx][ny].visited=true;
                que.offer(new int[]{nx,ny});
            }
        }
    }
     */
    static int [][] map;
    static boolean [][] visited;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> rain = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<map.length;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                int h = Integer.parseInt(st.nextToken());
                map[i][j++] =h;
                rain.add(h);
            }
        }
        Iterator<Integer> iter = rain.iterator();
        int max = 1;
        while (iter.hasNext()){
            visited = new boolean[N][N];
            int min = iter.next();
            int count =0;
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map.length;j++){
                    if(map[i][j]>min&&!visited[i][j]){
                        dfs(i,j,min);
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }
    public static void dfs(int r, int c, int min){
        visited[r][c]=true;
        for(int d=0;d<4;d++){
            int nx = r+dx[d];
            int ny = c+dy[d];

            if(nx<0 || ny<0 || nx>=map.length || ny>=map.length||visited[nx][ny] || map[nx][ny]<=min){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny]>min){
                dfs(nx,ny, min);
            }
        }
    }
}
