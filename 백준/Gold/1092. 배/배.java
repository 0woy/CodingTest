import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] crain;
    static List<Integer> box;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        crain = new int[n];
        isSelected = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crain);
        box.sort(Collections.reverseOrder());
        if (box.get(0) > crain[n - 1]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!box.isEmpty()) {
            int craneIdx = n - 1;
            int boxIdx = 0;

            while (craneIdx >= 0 && boxIdx < box.size()) {
                if(crain[craneIdx]>=box.get(boxIdx)) {
                    box.remove(boxIdx);
                    craneIdx--;
                }else{
                    boxIdx++;   // 못 들면 다음 박스
                }
            }
            time++;
        }
        System.out.println(time);
    }

    static int binarySearch(int kg) {
        int s = 0;
        int e = crain.length - 1;
        int mid = 0;
        while (s < e) {
            mid = (s + e) / 2;
            if (crain[mid] < kg) s = mid + 1;
            else if (crain[mid] > kg) e = mid;
            else return mid;
        }
        return mid;
    }
}
