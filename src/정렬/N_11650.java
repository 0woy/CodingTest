import java.io.*;
import java.util.*;

public class N_11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2차원 배열 정렬 다중조건
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            // 첫번째 숫자 기준 오름차순 후 같다면 두번째 숫자 기준 오름차순
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        /*
         * ==
         * Arrays.sort(point, (o1, o2) -> {
         * if (o1[0] == o2[0])
         * return o1[1] - o2[1];
         * else {
         * return o1[0] - o2[0];
         * }
         * });
         */

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }

    }

}
