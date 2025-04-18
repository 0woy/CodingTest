import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int kg = Integer.parseInt(br.readLine());
        int count = 0;
        if (kg % 5 == 1 || kg % 5 == 3) {
            count = kg / 5 + 1;
        } else if (kg % 5 == 2 || kg % 5 == 4) {
            count = kg / 5 + 2;
        } else if (kg == 7 || kg == 4) {
            count = -1;
        } else if (kg % 5 == 0) {
            count = kg / 5;
        }
        System.out.println(count);

    }
}
