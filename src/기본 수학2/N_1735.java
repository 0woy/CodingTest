import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int numer1 = Integer.parseInt(st.nextToken());
        int deno1 = Integer.parseInt(st.nextToken());
        
        st =new StringTokenizer(br.readLine());
        int numer2 = Integer.parseInt(st.nextToken());
        int deno2 = Integer.parseInt(st.nextToken());

        int numerator = -1;
        int denominator = -1;
        // 분모를 변경 안 해도 됨
        if(deno1 == deno2) {
            numerator = numer1 + numer2;

            // 바로 최대공약수 1까지 돌리기
            int gcd = gcd(deno1, numerator);
            numerator /=gcd;
            denominator = deno1/gcd;
        }
        else{
            //1. 분모간 최대공배수
            //2. 분자 x 최대공배수 합
            //3. 분자 분모끼리 최대공약수 1까지 돌리기

            int lcm = deno1*deno2/gcd(deno1, deno2);
            numer1 *= (lcm/deno1);
            numer2 *= (lcm/deno2);
            numerator = numer1+numer2;

            int gcd = gcd(numerator, lcm);
            numerator /=gcd;
            denominator = lcm/gcd;
        }
        System.out.println(numerator+" "+denominator);
    }

    public static int gcd(int a, int b){
        while(a!=0 && b!=0){
            if(a>b){
                a%=b;
            }else{
                b%=a;
            }
        }
        if(a==0){
            return b;
        }else{
            return a;
        }
    }
}
