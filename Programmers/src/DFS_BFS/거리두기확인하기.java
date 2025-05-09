package DFS_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 거리두기확인하기 {
    static boolean[][] visited;
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        int idx = 0;
        for (String[] test : places) {
            boolean isPossible = true;
            row:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (test[i].charAt(j) == 'P') {
                        visited= new boolean[5][5];
                        if (!bfs(test, i, j)) {
                            isPossible = false;
                            break row;
                        }
                    }
                }
            }
            answer[idx++] = isPossible ? 1 : 0;
        }
        for(int v: answer){
            System.out.print(v+" ");
        }
        return answer;
    }

    public static boolean bfs(String[] grid, int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int dist = cur[2];
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || grid[nx].charAt(ny) == 'X') {
                    continue;
                }
                if (!visited[nx][ny]) {
                    if (grid[nx].charAt(ny) == 'P') {
                        if (dist == 1) {
                            return false;
                        }
                    }
                    que.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });
    }
}
