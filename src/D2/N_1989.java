package D2;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

/*
"level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.

[제약 사항]
각 단어의 길이는 3 이상 10 이하이다.

[입력]
3
level
samsung
eye

[출력]
#1 1
#2 0
#3 1
 */
public class N_1989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=testcase;tc++){
            sb.append("#"+tc+" ");
            String str = br.readLine();
            int len = str.length();
            int i=0;
            // level : 0,4 1,3 len =5/2 = 2-1 =1 5-2 =3
            for(i=0;i<=len/2-1;i++){
                if(str.charAt(i)!=str.charAt(len-i-1)){
                    sb.append("0\n");
                    break;
                }
            }
            if(i>len/2-1)
                sb.append("1\n");
        }
        System.out.println(sb);
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
    }
}
