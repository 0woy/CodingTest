import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[][] map;

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (char v : br.readLine().toCharArray()) {
                    map[i][j] = v - '0';
                    total += map[i][j];
                    j++;
                }
            }

            int minus = 0;
            int len = n / 2;

            int x = 0, y = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) < len) minus += map[i][j];
                }
            }
            x = 0;
            y = n - 1;
            for (int i = 0; i < len; i++) {
                for (int j = len + 1; j < n; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) < len) minus += map[i][j];
                }
            }

            x = n-1;
            y =0;
            for (int i = len+1; i < n; i++) {
                for (int j = 0; j < len; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) < len) minus += map[i][j];
                }
            }

            x = n-1;
            y =n-1;
            for (int i = len+1; i < n; i++) {
                for (int j = len+1; j < n; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) < len) minus += map[i][j];
                }
            }

            sb.append(total-minus).append("\n");

        }
        System.out.println(sb);
    }
}
