import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    static String[][] map;
    static Set<String> set;
    static final int [] dx = {0,1,0,-1};
    static final int [] dy = {1,0,-1,0};
    static class Number{
        int x, y;
        String num;
        public Number(int x, int y, String n){
            this.x=x;
            this.y=y;
            this.num=n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            map = new String[4][4];
            for(int i=0;i<4;i++){
                map[i]= br.readLine().split(" ");
            }
            set =  new HashSet<>();
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    bfs(i, j);
                }
            }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
    static void bfs(int x, int  y){
        Queue<Number> que =new ArrayDeque<>();
        que.offer(new Number(x, y, map[x][y]));
        while(!que.isEmpty()){
            Number cur= que.poll();
            if (cur.num.length() >=7) {
                set.add(cur.num);
                continue;
            }
            for(int d=0;d<4;d++){
                int nx = cur.x  +dx[d];
                int ny = cur.y  +dy[d];

                if(nx <0 || ny<0 || nx >=4 || ny >=4) continue;
                que.offer(new Number(nx, ny, cur.num+map[nx][ny]));
            }
        }
    }
}
