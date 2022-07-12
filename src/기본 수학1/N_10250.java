import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int h, w, n;
        int[] num = new int[test_case];
        int[] floor = new int[test_case];
        StringTokenizer st;
        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n % h != 0) {
                floor[i] = n % h;
                num[i] = (n / h) + 1;
            } else if (n % h == 0) {
                floor[i] = h;
                num[i] = n / h;
            }
        }
        for (int i = 0; i < test_case; i++) {
            System.out.println(floor[i] * 100 + num[i]);
        }
    }
}
