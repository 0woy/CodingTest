import java.io.*;
import java.util.*;

public class N_25501 {
    static int r_count = 0;

    public static int recursion(String str, int start, int end) {
        r_count++;
        if (start >= end)
            return 1;
        else if (str.charAt(start) != str.charAt(end))
            return 0;
        else
            return recursion(str, start + 1, end - 1);
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            int p = isPalindrome(str[i]);
            int r = r_count;
            r_count = 0;
            sb.append(p + " " + r).append('\n');
        }

        System.out.println(sb);

    }
}
