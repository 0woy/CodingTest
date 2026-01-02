import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + "\n");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            ans = new int[n][n * 3];
            for (int i = 0; i < n; i++) {
                int j = 0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[i][j++] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                // 90도
                for (int j = 0; j < n; j++) {
                    sb.append(arr[n - 1 - j][i]);
                }
                sb.append(" ");
                // 180도
                for (int j = 0; j < n; j++) {
                    sb.append(arr[n - 1 - i][n - 1 - j]);
                }
                sb.append(" ");
                // 270도
                for (int j = 0; j < n; j++) {
                    sb.append(arr[j][n - 1 - i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}