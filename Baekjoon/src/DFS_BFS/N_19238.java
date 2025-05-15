package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_19238 {
    /**
     * Wrong ans
     * static int[][] map;
     * static final int[] dx = {-1, 0, 1, 0};
     * static final int[] dy = {0, -1, 0, 1};
     * static int fuel;
     * static int m;
     * <p>
     * public static void main(String[] args) throws IOException {
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * StringTokenizer st = new StringTokenizer(br.readLine());
     * int n = Integer.parseInt(st.nextToken());
     * m = Integer.parseInt(st.nextToken());
     * fuel = Integer.parseInt(st.nextToken());
     * <p>
     * map = new int[n + 1][n + 1];
     * for (int i = 1; i <= n; i++) {
     * st = new StringTokenizer(br.readLine());
     * for (int j = 1; j <= n; j++) {
     * map[i][j] = Integer.parseInt(st.nextToken());
     * }
     * }
     * st = new StringTokenizer(br.readLine());
     * int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
     * <p>
     * Map<String, int[]> p = new HashMap<>();
     * for (int i = 0; i < m; i++) {
     * st = new StringTokenizer(br.readLine());
     * int x = Integer.parseInt(st.nextToken());
     * int y = Integer.parseInt(st.nextToken());
     * map[x][y] = 2;
     * p.put(x + " " + y, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
     * }
     * if(p.containsKey(start[0]+" "+start[1])) {
     * boolean isOK = drive(start, p.get(start[0]+" "+start[1]));
     * int res = fuel;
     * if(!isOK) {
     * res=-1;
     * }
     * if(m==0){
     * res = fuel;
     * }
     * if(!isOK || m==0){
     * System.out.println(res);
     * return;
     * }
     * }
     * int res = bfs(start, p);
     * System.out.println(res);
     * }
     * <p>
     * public static int bfs(int[] start, Map<String, int[]> person) {
     * Queue<int[]> que = new ArrayDeque<>();
     * Set<String> visited = new HashSet<>();
     * que.add(start);
     * <p>
     * visited.add(start[0] +" "+start[1]);
     * while (!que.isEmpty()) {
     * int len = que.size();
     * fuel--;
     * if(fuel < 0) {return -1;}
     * start:
     * while(len-- > 0) {
     * int[] cur = que.poll();
     * <p>
     * for (int d = 0; d < 4; d++) {
     * int nx = cur[0] + dx[d];
     * int ny = cur[1] + dy[d];
     * <p>
     * if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 1) {
     * continue;
     * }
     * <p>
     * if(visited.contains(nx + " " + ny)) {
     * continue;
     * }
     * if (map[nx][ny] == 2) {
     * int [] goal = person.get(nx + " " + ny);
     * if (nx == goal[0] && ny==goal[1] || drive(new int[]{nx, ny}, goal)) {
     * if(m==0){return fuel;}
     * que.clear();
     * visited.clear();
     * <p>
     * map[nx][ny] = 0;
     * cur = person.get(nx + " " + ny);
     * que.add(cur);
     * map[cur[0]][cur[1]] = 0;
     * visited.add(cur[0] +" "+cur[1]);
     * <p>
     * break start;
     * } else {
     * return -1;
     * }
     * }else if(map[nx][ny] == 0){
     * que.add(new int[]{nx, ny});
     * visited.add(nx + " " + ny);
     * }
     * }
     * }
     * <p>
     * }
     * return -1;
     * }
     * <p>
     * public static boolean drive(int[] start, int[] goal) {
     * Queue<int[]> que = new ArrayDeque<>();
     * Set<String> visited = new HashSet<>();
     * que.add(start);
     * visited.add(start[0] + " " + start[1]);
     * int count =0;
     * while (!que.isEmpty()) {
     * int len = que.size();
     * count++;
     * fuel--;
     * if(fuel < 0) {return false;}
     * while (len-- > 0) {
     * int[] cur = que.poll();
     * for (int d = 0; d < 4; d++) {
     * int nx = cur[0] + dx[d];
     * int ny = cur[1] + dy[d];
     * if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 1||visited.contains(nx+" "+ny)) {
     * continue;
     * }
     * if (nx == goal[0] && ny == goal[1]) {
     * fuel +=count*2;
     * --m;
     * return true;
     * }
     * <p>
     * que.add(new int[]{nx, ny});
     * visited.add(nx+" "+ny);
     * }
     * }
     * }
     * return false;
     * }
     */
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static int fuel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        Map<Point, Point> p = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gx = Integer.parseInt(st.nextToken());
            int gy = Integer.parseInt(st.nextToken());
            p.put(new Point(x, y), new Point(gx, gy));
        }

        for (int i = 0; i < m; i++) {
            Entity passenger = shortestPassenger(start, p);
            if (passenger == null || passenger.dist >fuel) {
                System.out.println(-1);
                return;
            }
            fuel -= passenger.dist;
            Point goal  = p.get(passenger.p);
            int dist = drive(passenger.p, goal);
            if(dist==-1 || dist > fuel){
                System.out.println(-1);
                return;
            }
            fuel +=dist;
            start = goal;
            p.remove(passenger.p);
        }
        System.out.println(fuel);
    }

    public static Entity shortestPassenger(Point start, Map<Point, Point> p) {
        Queue<Entity> que = new LinkedList<>();
        que.offer(new Entity(start, 0));
        boolean[][] visited = new boolean[map.length][map[0].length];
        List<Entity> candidates = new ArrayList<>();
        visited[start.x][start.y] = true;
        while (!que.isEmpty()) {
            int len = que.size();
            find:
            while (len-- > 0) {
                Entity entity = que.poll();
                Point cur =entity.p;
                if(p.containsKey(cur)) {
                    candidates.add(entity);
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny] || map[nx][ny]==1) continue;

                    visited[nx][ny] =  true;
                    que.offer(new Entity(new Point(nx, ny), entity.dist+1));
                }
            }
            if(!candidates.isEmpty()) break;
        }
        if(candidates.isEmpty()) {return null;}
        Collections.sort(candidates);
        return candidates.get(0);
    }
    public static int drive(Point start, Point end) {
        Queue<Point> que = new LinkedList<>();
        que.offer(start);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start.x][start.y] = true;

        int dist =0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len-- > 0) {
                Point cur = que.poll();
                if(cur.x == end.x && cur.y == end.y) {
                    return dist;
                }
                for(int d=0;d<4;d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny] || map[nx][ny]==1) continue;
                    visited[nx][ny] = true;
                    que.offer(new Point(nx, ny));
                }
            }
            dist++;
        }
        return -1;
    }
    static class Entity implements Comparable<Entity> {
        Point p;
        int dist;

        public Entity(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }

        @Override
        public int compareTo(Entity o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            if(this.p.x!=o.p.x) return this.p.x-o.p.x;
            return this.p.y-o.p.y;
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point point)) return false;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

