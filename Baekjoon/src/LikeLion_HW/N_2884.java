/*
시 -> 분 변환을 통해 접근
result = hour * 60 + minuite
ans = result - 45

hour = ans / 60
min = ans % 60

if hour >= 24
hour = ans / 60 % 24
 */

package LikeLion_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        if(hour == 0) hour = 24;
        int res = hour * 60 + min - 45;

        hour = res/60%24;
        min = res%60;

        sb.append(hour+" ").append(min);
        System.out.println(sb);
    }
}
