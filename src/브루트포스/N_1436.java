import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1436 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;
        while (count != n) {
            num++;

            if (String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count =0;
        int val = 666;
        while(true){
            if(String.valueOf(val).contains("666")){
                count++;
            }
            if(count == n){
                System.out.println(val);
                return;
            }
            val++;
        }

    }
}
