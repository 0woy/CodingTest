import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int[][] map;
    static int[][] dp;
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dp = new int[n][n];
            for (int i = 0; i < map.length; i++) {
                int j = 0;
                for (String ch : br.readLine().split(" ")) {
                    map[i][j++] = Integer.parseInt(ch);
                }
            }
            int bestNum = Integer.MAX_VALUE;
            int bestLen = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    int len = dfs(i, j);
                    if (len > bestLen || (len == bestLen && map[i][j] < bestNum)) {
                        bestLen = len;
                        bestNum = map[i][j];
                    }
                }
            }
            sb.append(bestNum).append(" ").append(bestLen).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        int cur= map[r][c];
        dp[r][c]=1;

        for(int d=0;d<4;d++){
            int nx = r+dx[d];
            int ny = c+dy[d];
            if(nx < 0 || ny <0 || nx>=map.length || ny>=map.length) continue;
            if(map[nx][ny] == cur +1){
                dp[r][c] = dfs(nx,ny)+1;
                break;
            }
        }
        return dp[r][c];
    }
}
