import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class N_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            arr[i] = Character.getNumericValue(x);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
