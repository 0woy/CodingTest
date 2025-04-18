import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat.Style;
import java.util.PrimitiveIterator;

import javax.swing.border.MatteBorder;

public class N_4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (;;) {
            boolean[] prime;
            int x = Integer.parseInt(br.readLine());
            if (x == 0)
                break;
            else {
                int num = 0;
                int start = x;
                int end = x * 2;
                prime = new boolean[end + 1];
                get_prime(prime);

                for (int i = start + 1; i <= end; i++) {
                    if (!prime[i])
                        num++;
                }
                sb.append(num).append('\n');

            }
        }
        System.out.print(sb);

    }

    static void get_prime(boolean[] prime) {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
