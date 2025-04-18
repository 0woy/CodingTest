package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.

[제약 사항]
각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.

[입력]
3
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY

[출력]
#1 5
#2 7
#3 6
 */
public class N_2007 {
    public static int check(String str){
        int end =1;
        while(end<10) {
            String tmp = str.substring(0,end);
            int len = tmp.length();
            if(tmp.equals(str.substring(len,2*len)))    return len;
            end++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=testcase;tc++){
            sb.append("#"+tc+" ");
            String str = br.readLine();
            sb.append(check(str)+"\n");
        }
        System.out.println(sb);
    }
}
