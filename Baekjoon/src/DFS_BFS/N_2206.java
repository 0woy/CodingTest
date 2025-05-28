package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2206 {
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1][m + 1][2];
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int result = bfs(arr);
        System.out.println(result);
    }

    public static int bfs(int[][] arr) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 1, 0, 1});
        visited[1][1][0] = true;
        visited[1][1][1] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int d = 0; d < 4; d++) {
                int x = cur[0] + dx[d];
                int y = cur[1] + dy[d];
                int brocked = cur[2];
                if (x == arr.length - 1 && y == arr[0].length - 1) {
                    return cur[3] + 1;
                }
                if (x <= 0 || y <= 0 || x >= arr.length || y >= arr[0].length) continue;
                if (visited[x][y][brocked]) continue;
                if (arr[x][y] == 1) {
                    if (brocked == 0) {
                        visited[x][y][1] = true;
                        que.add(new int[]{x, y, 1, cur[3] + 1});
                    }
                    continue;
                }
                visited[x][y][brocked] = true;
                que.add(new int[]{x, y, brocked, cur[3] + 1});
            }
        }
        return -1;
    }
}
