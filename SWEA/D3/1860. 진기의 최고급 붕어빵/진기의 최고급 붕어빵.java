import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int[] arrive = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(arrive);
            if (arrive[0] < m) {
                sb.append("Impossible\n");
                continue;
            }
            long total = 0;
            int idx = 0;
            boolean isPossible = true;
            for (int i = 1; i <= arrive[n - 1]; i++) {
                if (i % m == 0) {
                    total += k;
                }
                if (i == arrive[idx]) {
                    total--;
                    idx++;
                    if (total < 0) {
                        isPossible = false;
                        break;
                    }
                }
            }
            String res = (isPossible)?"Possible":"Impossible";
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
}
