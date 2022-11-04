import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5597 {
    static public void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] student = new boolean[31];
        student[0] = true;
        for (int i = 1; i < 29; i++) {
            int k = Integer.parseInt(br.readLine());
            student[k] = true;
        }
        for (int i = 1; i < 31; i++) {
            if (student[i])
                continue;
            else
                System.out.println(i);
        }
    }
}
