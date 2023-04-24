/*
N_2522 별찍기-12
예제를 보고 규칙을 유추한 후 별 찍기
입력: 3
출력:
  *
 **
***
 **
  *
 */
package LikeLion_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class N_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String blank = " ".repeat(n-i-1);
            String star ="*".repeat(i+1);
            System.out.println(blank+star);
        }
        for(int i=n-2;i>=0;i--){
            String blank = " ".repeat(n-i-1);
            String star = "*".repeat(i+1);
            System.out.println(blank+star);
        }
    }
}
