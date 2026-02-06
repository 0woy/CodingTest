import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] yung, gyu;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            gyu = new int[9];
            yung = new int[9];
            boolean[] usedInGyu = new boolean[19];

            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                usedInGyu[gyu[i]] = true;
            }
            int tmp = 0;
            for (int i = 1; i <= 18; i++) {
                if (!usedInGyu[i]) yung[tmp++] = i;
            }

            win = 0;
            lose = 0;

            game(0, 0,0,0);    // 깊이, 비트플래그, 규영 점수, 인영 점수

            sb.append(win + " " + lose).append("\n");
        }
        System.out.println(sb);
    }

    static void game(int cnt, int flag, int gt, int yt) {
        if(cnt==9){
            if(gt > yt) win++;
            else if(gt < yt) lose++;
            return;
        }

        for(int i=0;i<9;i++){
            if((flag & (1 << i))==0){
                int sum = gyu[cnt]+yung[i];
                if(gyu[cnt] > yung[i]){
                    game(cnt+1, flag | (1 << i), gt+sum, yt);
                }else{
                    game(cnt+1, flag | (1 << i), gt, yt+sum);
                }
            }
        }

    }
}
