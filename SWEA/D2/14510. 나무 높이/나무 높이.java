import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(arr);
            max = arr[n - 1];
            if (arr[0] == max) {
                sb.append(0).append("\n");
                continue;
            }
            int count2 = 0;
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == max) break;
                int diff = max - arr[i];
                count2 += diff / 2;
                count1 += diff % 2;
            }
            while (count1 < count2 - 1) {
                count2--;
                count1 += 2;
            }
            int total = 0;
            sb.append((count1 > count2) ? count1 * 2 - 1 : count2 * 2).append("\n");
        }
        System.out.println(sb);

    }
}
