import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = factorial(N);
        System.out.println(sum);
    }

    static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
}
