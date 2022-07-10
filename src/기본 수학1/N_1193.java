import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class N_1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int range = 1;
        int count = 1;
        int prev = 0;
        int numerator, denominator;
        if (N == 1) {
            numerator = 1;
            denominator = 1;
        } else {
            for (;;) {
                if (N > range) {
                    count += 1;
                    prev = range;
                    range = range + count;
                } else {
                    break;
                }
            }
        }
        int pos = N - prev;

        if (count % 2 == 0) { // 짝수
            numerator = pos;
            denominator = count - (pos - 1);
        } else {
            numerator = count - (pos - 1);
            denominator = pos;
        }
        System.out.println(numerator + "/" + denominator);
    }

}
