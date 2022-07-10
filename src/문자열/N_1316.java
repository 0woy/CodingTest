import java.io.*;

import javax.swing.undo.StateEdit;

public class N_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (check(str) == true)
                count++;
        }
        System.out.println(count);
    }

    static boolean check(String str) {
        boolean check[] = new boolean[26];
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }

        }
        return true;

    }

}
