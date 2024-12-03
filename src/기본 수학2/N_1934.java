import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class N_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc =Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                bw.write(b+"\n");
                continue;
            }
            if (b == 1) {
                bw.write(a+"\n");
                continue;
            }
            int gcd = gcd(a,b);
            int lcm = a*b/gcd;
            bw.write(lcm+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int gcd(int a, int b){
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
