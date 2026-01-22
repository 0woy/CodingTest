import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int one = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) one++;
            else if (num <= 0) minus.add(num);
            else plus.add(num);
        }
        long total = 0;
        total += getTotal(minus);
        total += getTotal(plus);
        total += one;
        System.out.println(total);
    }

    private static long getTotal(PriorityQueue<Integer> pq) {
        long total = 0;
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                total += pq.poll();
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            total += a * b;
        }
        return total;
    }
}

/**
 * -10,-20, -1
 */