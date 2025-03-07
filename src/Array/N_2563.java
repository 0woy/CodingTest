package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] box = new int[100][100];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] rec = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rec[i][0] = Integer.parseInt(st.nextToken()); // 좌하단 x좌표
            rec[i][1] = Integer.parseInt(st.nextToken()); // 좌하단 y좌표
        }

    }
}
