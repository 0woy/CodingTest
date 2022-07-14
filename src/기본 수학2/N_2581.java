import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2581 {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        prime = new boolean[end + 1];
        get_prime();

        // 소수 합 및 최소값
        int sum = 0;
        int min = 0;
        for (int i = start; i <= end; i++) {
            if (prime[i] == false) {
                sum += i;
                if (min == 0)
                    min = i;
            }
        }
        if (sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i)
                prime[j] = true;
        }
    }
}
