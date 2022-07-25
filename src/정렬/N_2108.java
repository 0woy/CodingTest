import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        int avg = (int) Math.round(sum / arr.length);// 평균
        int mid = arr[(arr.length / 2)]; // 중앙값
        int range = arr[arr.length - 1] - arr[0]; // 범위
        sb.append(avg + "\n").append(mid + "\n");

        boolean sev = false;
        int mode_max = 0;
        int mode = 10000;
        for (int i = 0; i < arr.length; i++) {
            int jump = 0;
            int count = 1;
            int value = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (value != arr[j]) {
                    break;
                }
                jump++;
                count++;
            }
            if (count > mode_max) {
                mode_max = count;
                sev = true;
                mode = value;
            } else if (count == mode_max && sev) {
                mode = value;
                sev = false;
            }
            i += jump;
        }
        sb.append(mode + "\n").append(range);
        System.out.print(sb);
    }
}
