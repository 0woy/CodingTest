package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

0개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
(소수점 첫째 자리에서 반올림한 정수를 출력한다.)


[제약 사항]
각 수는 0 이상 10000 이하의 정수이다.

[입력]
3
3 17 1 39 8 41 2 32 99 2
22 8 5 123 7 2 63 7 3 46
6 63 2 3 58 76 21 33 8 1


[출력]
#1 18
#2 20
#3 24
 */
public class N_1984 {
    public static long sumArr(int [] arr){
        long sum =0;
        int min = arr[0];
        int max = arr[arr.length-1];
        int count =0;
        for(int i=1;i<arr.length-1;i++){
            if(min==arr[i]||max==arr[i]) continue;
            else  {
                sum +=arr[i];
                count++;
            }
        }

        return Math.round(sum/8.0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=testcase;tc++){
            sb.append("#"+tc+" ");
            st = new StringTokenizer(br.readLine());
            int [] arr = new int[st.countTokens()];
            int  i=0;
            while (st.hasMoreTokens()){
                arr[i++] =Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            sb.append(sumArr(arr)+"\n");
        }
        System.out.println(sb);
    }
}
