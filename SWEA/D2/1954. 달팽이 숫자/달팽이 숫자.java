import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[][] map;
    final static int[] dx = {0,1,0,-1};
    final static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc =Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+"\n");
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dfs(0,0,1,0);
            for(int [] row: map){
                for(int c: row){
                    sb.append(c+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y, int v, int dir){
        map[x][y] =v;
        if(v == map.length * map.length) return;

        int nx = x+dx[dir%4];
        int ny = y+dy[dir%4];

        if(nx < 0 || ny <0 || nx>=map.length || ny>=map.length || map[nx][ny]!=0){
            dir++;
            nx = x+dx[dir%4];
            ny = y+dy[dir%4];
        }
        dfs(nx,ny,v+1,dir);

    }
}
