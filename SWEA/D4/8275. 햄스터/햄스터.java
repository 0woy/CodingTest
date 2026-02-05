import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{
    static StringTokenizer st;
    static BufferedReader br;
    static List<int[]> operators;

    static int n, x, m, maxHam, answer[];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()) + 1;
            x = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxHam = -1;
            answer = new int[n];
            initOperators(m);
            backtrack(1, new int[n]);

            if (maxHam == -1) sb.append(-1);
            else {
                for (int k = 1; k < n; k++) sb.append(answer[k] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void backtrack(int cur, int[] ham) {
        if (cur == n) {
            if (isValid(ham)) {
                int total = Arrays.stream(ham).sum();
                if (total > maxHam) {
                    maxHam = total;
                    answer = Arrays.copyOf(ham, ham.length);
                }
            }
            return;
        }

        for (int i = 0; i <= x; i++) {
            ham[cur] = i;
            backtrack(cur + 1, ham);
        }

    }

    static boolean isValid(int[] ham) {
        for (int[] op : operators) {
            int sum = 0;
            for (int l = op[0]; l <= op[1]; l++) {
                sum += ham[l];
                if (sum > op[2]) return false;
            }
            if (sum < op[2]) return false;
        }
        return true;
    }

    static void initOperators(int m) {
        operators = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int sum = Integer.parseInt(st.nextToken());
            operators.add(new int[]{l, r, sum});
        }

        operators.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
    }
}