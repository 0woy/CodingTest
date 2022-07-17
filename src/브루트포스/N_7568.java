import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_7568 {
    static int[][] person;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        person = new int[test_case][2];
        rank = new int[test_case];

        StringTokenizer st;
        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < test_case; i++) {
            for (int j = i + 1; j < test_case; j++) {
                if (person[i][0] < person[j][0] &&
                        person[i][1] < person[j][1])
                    rank[i]++;
                else if (person[i][0] > person[j][0] &&
                        person[i][1] > person[j][1])
                    rank[j]++;
            }
        }
        for (int i = 0; i < rank.length; i++) {
            rank[i] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : rank) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
