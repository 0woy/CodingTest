import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_27433 {
    public static long factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long res = factorial(n);
        System.out.println(res);
        return;
    }
}
