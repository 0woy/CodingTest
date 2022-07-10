import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int day = 0;
        day = (goal - down) / (up - down);
        if ((goal - down) % (up - down) != 0)
            day++;
        System.out.print(day);
    }
}
