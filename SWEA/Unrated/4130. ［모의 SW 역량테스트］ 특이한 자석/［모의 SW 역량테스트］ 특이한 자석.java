import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t=1; t<=tc;t++){
            sb.append("#").append(t).append(" ");
            list = new List[4];
            int rotate = Integer.parseInt(br.readLine());

            for(int i=0;i<4;i++){
                list[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()){
                    list[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int i=0;i<rotate;i++){
                st = new StringTokenizer(br.readLine());
                int pos = Integer.parseInt(st.nextToken())-1; // 회전 위치
                int dir = Integer.parseInt(st.nextToken()); // 회전 방향

                int left = list[pos].get(6);
                int right = list[pos].get(2);
                move(dir, list[pos]);

                rotate(pos-1, dir*-1, left,2,-1);
                rotate(pos+1, dir*-1,right,6,1);
            }

            int total = 0;
            for(int i=0;i<4;i++){
                if(list[i].get(0)==1){
                    total+= (int) Math.pow(2, i);
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
    public static void rotate(int pos, int dir, int prev, int idx, int plus){
        if(pos<0 || pos>=4) return;
        if(list[pos].get(idx).equals(prev)) return;

        int tmp = list[pos].get((idx+4)%8);
        move(dir, list[pos]);

        rotate(pos+plus, dir*-1, tmp, idx, plus);
    }

    static void move(int dir, List<Integer> magnet){
        if(dir==1) {
            int r = magnet.remove(7);
            magnet.add(0,r);
        }else{
            int r = magnet.remove(0);
            magnet.add(r);
        }
    }
}