import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            int[] buildings = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            int res = calc(buildings);
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

    static int calc(int[] buildings) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(buildings[i]);
        }

        int total = 0;
        for (int k = 5; k < buildings.length; k++) {
            if (Collections.max(list).equals(list.get(2))) {
                int sMax = -1;
                for (int i = 0; i < list.size(); i++) {
                    if (sMax < list.get(i)) {
                        if (i != 2) {
                            sMax = list.get(i);
                        }
                    }
                }
                total = total + (list.get(2) - sMax);
            }
            list.remove(0);
            list.add(buildings[k]);
        }
        if (Collections.max(list).equals(list.get(2))) {
            int sMax = -1;
            for (int i = 0; i < list.size(); i++) {
                if (sMax < list.get(i)) {
                    if (i != 2) {
                        sMax = list.get(i);
                    }
                }
            }
            total = total + (list.get(2) - sMax);
        }
        return total;
    }
}
