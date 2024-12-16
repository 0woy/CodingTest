import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10870 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = Fibonacci(N);
        System.out.println(sum);
    }

    static int Fibonacci(int n) {
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
     */
    public static int fibonacci(int n){
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = fibonacci(n);
        System.out.println(res);

    }
}
