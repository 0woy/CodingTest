package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_19238 {
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
        int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        Map<String, int[]> p = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
            p.put(x + " " + y, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int res = bfs(start, p);
        System.out.println(res);
    }

    public static int bfs(int[] start, Map<String, int[]> person) {
        Queue<int[]> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.add(start);
        visited.add(start[0] +" "+start[1]);
        while (!que.isEmpty()) {
            int len = que.size();

            while(len-- > 0) {
                int[] cur = que.poll();
                start:
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 1) {
                        continue;
                    }

                    if(visited.contains(nx + " " + ny)) {
                        continue;
                    }
                    if (map[nx][ny] == 2) {
                        boolean isSuccess = drive(new int[]{nx, ny}, person.get(nx + " " + ny));
                        if (isSuccess) {
                            que.clear();
                            visited.clear();
                            cur = person.get(nx + " " + ny);
                            que.add(cur);
                            visited.add(cur[0] +" "+cur[1]);
                            break start;
                        } else {
                            return -1;
                        }
                    }else if(map[nx][ny] == 0){
                        que.add(new int[]{nx, ny});
                        visited.add(nx + " " + ny);
                    }
                }
            }
            fuel--;
            if(fuel < 0) {return -1;}
        }
        return fuel;
    }

    public static boolean drive(int[] start, int[] goal) {
        Queue<int[]> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.add(start);
        visited.add(start[0] + " " + start[1]);
        int count =0;
        while (!que.isEmpty()) {
            int len = que.size();
            count++;
            fuel--;
            if(fuel < 0) {return false;}
            while (len-- > 0) {
                int[] cur = que.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 1) {
                        continue;
                    }
                    if (nx == goal[0] && ny == goal[1]) {
                        fuel +=count*2;
                        return true;
                    }

                    if(visited.contains(nx+" "+ny)) {
                        continue;
                    }
                    que.add(new int[]{nx, ny});
                    visited.add(nx+" "+ny);
                }
            }

        }
        return false;
    }
}

