import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_15829 {
    public static void main(String[] args) throws IOException {
        final int m = 1234567891;
        final int r = 31;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        long p=1;
        for(char ch : str.toCharArray()){
             sum += (ch-'a'+1)*p;
             p  = (p*31)%m;
        }
        System.out.println(sum%m);
    }
}
