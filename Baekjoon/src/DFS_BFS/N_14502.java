package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class N_14502 {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean inRange(int n, int m ){
            return x >=0 && x<n && y>=0 && y<m;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Point> empty = new ArrayList<>();
        List<Point> virus = new ArrayList<>();
        Set<Point> walls = new HashSet<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                int cur = Integer.parseInt(st.nextToken());
                switch (cur){
                    case 0: empty.add(new Point(i,j)); break;
                    case 1: walls.add(new Point(i,j)); break;
                    case 2: virus.add(new Point(i,j)); break;
                }
                j++;
            }
        }

        int min = Integer.MAX_VALUE;
        List<List<Point>> cases = combinations(empty);
        for(List<Point> w: cases){
            walls.addAll(w);
            min = Math.min(min, bfs(virus, walls, n, m));
            w.forEach(walls::remove);
        }
        System.out.println(n*m - min - walls.size()-3);

    }

    public static List<List<Point>> combinations(List<Point> empty){
        List<List<Point>> res = new ArrayList<>();
        combination_inner(res, empty, new ArrayList<>(), 0);
        return res;
    }

    public static void combination_inner(List<List<Point>> res, List<Point> empty, List<Point> cases, int start){
        if(cases.size() == 3){
            res.add(new ArrayList<>(cases));
            return;
        }

        for(int i = start; i < empty.size(); i++){
            cases.add(empty.get(i));
            combination_inner(res, empty,cases, i+1);
            cases.remove(cases.size() - 1);
        }
    }

    public static int bfs(List<Point> virus, Set<Point> walls, int n, int m){

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Queue<Point> que = new ArrayDeque<>(virus);
        Set<Point> visited = new HashSet<>(virus);
        int poison =virus.size();
        while (!que.isEmpty()){
            Point cur = que.poll();
            for(int d = 0; d < dx.length; d++){
                int x = cur.x + dx[d];
                int y = cur.y + dy[d];
                Point next = new Point(x, y);
                if(next.inRange(n, m) && !visited.contains(next)&&!walls.contains(next)){
                    poison++;
                    visited.add(next);
                    que.add(next);
                }
            }
        }
        return poison;
    }
}
