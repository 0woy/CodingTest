/*
N_10757 큰수 A+B
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

Note.
BigInter는 java.math내에 있으며 초기화하기 위해선 문자열을 인자 값으로 넘겨줌.
-> BigInteger가 문자열로 되어있기 때문
문자열이기 때문에 일반적인 사칙연산이 안되므로 내부 메서드를 사용해야함.
ex) big1+big2 = big1.add(big2);
    big*big2 = big1.mulitply(big2);
 */
package LikeLion_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B= new BigInteger(st.nextToken());
        System.out.println(A.add(B));
    }
}
