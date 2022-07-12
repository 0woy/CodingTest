import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        int apart[][];
        int ans[] = new int[test_case];

        for (int i = 0; i < test_case; i++) {
            int f = Integer.parseInt(br.readLine());
            int h = Integer.parseInt(br.readLine());
            apart = new int[f + 1][h];
            apart = calc(f + 1, h);
            ans[i] = apart[f][h - 1];
        }
        for (int i : ans)
            bw.write(i + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int[][] calc(int floor, int ho) {
        int[][] apart = new int[floor][ho];
        int count = 1;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < ho; j++) {
                if (i == 0)
                    apart[i][j] = count++;
                else if (j == 0 && i != 0)
                    apart[i][j] = 1;
                else
                    apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }
        return apart;
    }
}
