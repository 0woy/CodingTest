import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int [] score = new int[n];
        for(int i=0;i<n;i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);
        int except = (int)Math.round(n*0.15);
        double total = 0;
        for(int i=except;i<score.length-except;i++){
            total+=score[i];
        }
        n = n-except*2;
        int avg = (int) Math.round(total/n);

        System.out.println(avg);

    }
}
