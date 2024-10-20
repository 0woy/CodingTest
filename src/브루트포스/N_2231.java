import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2231 {
    /** Previous SOLVE
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String x = Integer.toString(n);
        int length = x.length();

        for (int i = n - (9 * length); i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (i == n) {
                System.out.println(0);
            }
            if (sum + i == n) {
                System.out.println(i);
                break;
            } else {
                continue;
            }
        }

    }
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<n;i++){
            int cur = i;
            int sum = cur;
            while(cur !=0){
                sum += cur%10;
                cur/=10;
            }
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
