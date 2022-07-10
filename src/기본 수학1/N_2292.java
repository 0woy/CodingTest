import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2292 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 1;
        if (n == 1) {
            count = 1;
        }

        else {
            while (n > range) {
                range = range + (count * 6);
                count++;
            }
        }
        System.out.println(count);

    }
}
