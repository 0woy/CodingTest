import java.io.*;
import java.util.*;

public class N_2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String alpha[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        for (int i = 0; i < alpha.length; i++) {
            if (str.contains(alpha[i])) {
                str = str.replace(alpha[i], "?");
            }

        }
        System.out.print(str.length());

    }
}