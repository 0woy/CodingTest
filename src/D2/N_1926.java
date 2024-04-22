package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.
예를 들어 숫자 35의 경우 박수 한 번, 숫자 36의 경우 박수를 두번 쳐야 한다.

입력으로 정수 N 이 주어졌을 때, 1~N 까지의 숫자를
게임 규칙에 맞게 출력하는 프로그램을 작성하라.
박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
여기서 주의해야 할 것은 박수 한 번 칠 때는 - 이며, 박수를 두 번 칠 때는 - - 가 아닌 -- 이다.

[제약사항]
N은 10이상 1,000이하의 정수이다. (10 ≤ N ≤ 1,000)

[입력]
입력으로 정수 N 이 주어진다.

[출력]
1 ~ N까지의 숫자를 게임 규칙에 맞게 출력한다.
 */
public class N_1926 {
    public static StringBuilder sb;
    public static int count369(String str){
        int three= str.length()-str.replace(String.valueOf(3), "").length();
        int six= str.length()-str.replace(String.valueOf(6), "").length();
        int nine= str.length()-str.replace(String.valueOf(9), "").length();
        return three+six+nine;
    }
    public static void addDash(int count){
        for(int i=0;i<count;i++)
            sb.append("-");
        sb.append(" ");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++){
            int check= count369(String.valueOf(i));
            if(check == 0)  sb.append(i+" ");
            else    addDash(check);
        }

        System.out.println(sb);
    }
}
