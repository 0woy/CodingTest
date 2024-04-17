package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 문제
10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.

- 입력
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.

 - 출력
출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
public class N_2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int i=1;i<=testcase;i++){
            int sum =0;
            sb.append("#"+i+" ");
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                int current = Integer.parseInt(st.nextToken());
                if (current % 2 != 0) {
                    sum += current;
                }
            }
            sb.append(sum+"\n");
        }

        System.out.println(sb);
    }
}
