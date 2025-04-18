import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = (int) (Math.pow(2, N) - 1);
        sb.append(K + "\n");
        Hanoi(N, 1, 2, 3);
        System.out.print(sb);
    }

    static void Hanoi(int n, int start, int via, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        Hanoi(n - 1, start, to, via);
        sb.append(start + " " + to + "\n");
        Hanoi(n - 1, via, start, to);
    }
}
