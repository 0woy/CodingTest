package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int [] nums = new int[n];
        int bigger_idx = -1;
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(bigger_idx < nums[i])  bigger_idx=i;
        }
        
        int divisor = nums[((n+bigger_idx)+1)%n];   // 제수
        int dividend =  nums[bigger_idx];           // 피제수
        boolean check = false;

        int gcd=0, remain=0;
        while(true){
                remain = dividend%divisor;
                if(remain == 0) {    // 나누어 떨어진다면
                    if(n==2 || check){
                        gcd = divisor;  // 최대공약수
                        break;
                    }
                    else{
                        dividend = nums[((n+bigger_idx)+2)%n];
                        check = true;
                    }
                }
                else{   // 반복
                    dividend = divisor;
                    divisor = remain;
                }
        }

        // 공약수 구하기
        sb.append(1+"\n");
        if(gcd!=1) {
            for (int i = 2; i < gcd / 2 + 1; i++) {
                if (gcd % i == 0) sb.append(i + "\n");
                else continue;
            }
            sb.append(gcd);
        }
        System.out.print(sb);

    }
}
