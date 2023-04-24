/*
N_14909 양수 개수 세기
주어진 N개의 정수 중에서 양의 정수의 개수를 출력하는 프로그램을 작성하시오.

 */
package LikeLion_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count=0;
        while(st.hasMoreTokens()){
            if(Integer.parseInt(st.nextToken())>0)
                count++;
        }
        System.out.println(count);


    }
}

