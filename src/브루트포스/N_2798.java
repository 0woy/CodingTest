import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2798 {
    static int[] card, numbers;
    static int n, m, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int size = (n * (n - 1) * (n - 2)) / 6;
        card = new int[n];
        numbers = new int[3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            card[i] = Integer.parseInt(st.nextToken());

        comb(0, 0);

        System.out.println(res);
    }

    public static void comb(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int v : numbers) {
                sum += v;
            }
            if (sum <= m && sum > res) {
                res = sum;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[cnt] = card[i];
            comb(cnt + 1, i + 1);
        }
    }

}