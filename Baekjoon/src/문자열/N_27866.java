/*
문제: 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램
입력:
Sprout
3
출력:
r
 */
package 문자열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class N_27866 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());

            System.out.println(str.charAt(n-1));
        }
}

