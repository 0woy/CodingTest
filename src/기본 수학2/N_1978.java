import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        int[] test = new int[test_case];
        int check = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < test_case; i++) {
            test[i] = Integer.parseInt(st.nextToken());
            if (prime(test[i]))
                check++;
        }
        System.out.println(check);
    }

    static boolean prime(int test) {
        if (test == 1)
            return false;
        for (int i = 2; i * i <= test; i++) {
            if (test % i == 0)
                return false;
        }
        return true;

    }
}
