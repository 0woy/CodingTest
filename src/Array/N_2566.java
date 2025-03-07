package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] check = new int[9][9];
        int max = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                check[i][j] = Integer.parseInt(st.nextToken());
                if (max <= check[i][j]) {
                    max = check[i][j];
                    row = i + 1;
                    col = j + 1;
                }

            }
        }
        System.out.println(max);
        System.out.printf("%d %d", row, col);

    }
}
