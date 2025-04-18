import java.io.*;
import java.util.StringTokenizer;

public class N_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        if(a==1){
            bw.write(b+"\n");
        }
        else if (b == 1) {
            bw.write(a+"\n");
        }
        else {
            long gcd = gcd(a, b);
            long lcm = a * b / gcd;
            bw.write(lcm + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static long gcd(long a, long b){
        while(a!=0 && b!=0){
            if(a>b){
                a %=b;
            }else{
                b%=a;
            }
        }
        return a==0?b:a;
    }
}
