import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static int[][] map;
    static int answer = 0;
    static int[] dx = {0, 0, -1};   // l,r, up
    static int[] dy = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");
            br.readLine();
            map = new int[100][100];
            int x = 0;
            int y = 0;
            for (int i = 0; i < 100; i++) {
                int j = 0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                    j++;
                }
            }
            dfs(x, y);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static boolean dfs(int x, int y) {
        if (x == 0) {
            answer = y;
            return true;
        }
        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100 && map[nx][ny] == 1) {
                map[nx][ny]=0;
                if(dfs(nx, ny)) return true;
            }
        }
        return false;
    }
}
