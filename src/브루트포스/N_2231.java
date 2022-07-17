import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String x = Integer.toString(n);
        int length = x.length();

        for (int i = n - (9 * length); i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (i == n) {
                System.out.println(0);
            }
            if (sum + i == n) {
                System.out.println(i);
                break;
            } else {
                continue;
            }
        }

    }
}
