import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    static int[] dx = {0, 0, -1};
    static int[] dy = {1, -1, 0};
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            res = -1;
            sb.append("#" + br.readLine() + " ");
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                int j = 0;
                for (String s : br.readLine().split(" ")) {
                    map[i][j++] = Integer.parseInt(s);
                }
            }
            for (int i = 0; i < 100; i++) {
                if (map[99][i] == 2) {
                    dfs(map, 98, i);
                    sb.append(res + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static void dfs(int[][] map, int row, int col) {
        if (row == 0) {
            res = col;
            return;
        }
        for (int d = 0; d < 3; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                dfs(map, nx, ny);
                if(res != -1) return;
            }
        }
    }
}

