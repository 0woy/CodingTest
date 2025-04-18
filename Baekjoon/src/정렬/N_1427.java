import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N_1427 {
    /** Previous Solve
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
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(char c: str.toCharArray()){
            pq.add(c-'0');
        }
        while (!pq.isEmpty()){
            bw.write(pq.poll()+'0');
        }
        bw.flush();
        bw.close();

    }
}
