import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9020 {
    static boolean[] prime = new boolean[10001];;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        get_prime();

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int p, q;
            p = q = n / 2;
            for (;;) {
                if (!prime[p] && !prime[q]) {
                    sb.append(q).append(' ').append(p).append('\n');
                    break;
                }

                p++;
                q--;

            }

        }
        System.out.print(sb);
    }

    static void get_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
