/*
N_2446 별찍기-9
예제를 보고 규칙을 유추한 후 별찍기
입력: 5
출력:
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********

 */
package LikeLion_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String blank = " ".repeat(i);
            String star ="*".repeat(n*2-i*2-1);
            System.out.println(blank+star);
        }
        for(int i=n-2;i>=0;i--){
            String blank = " ".repeat(i);
            String star ="*".repeat(n*2-i*2-1);
            System.out.println(blank+star);
        }
    }
}

