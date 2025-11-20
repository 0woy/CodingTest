import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    static boolean [][] visited;
    final static int [] dx = {0,1,0,-1};
    final static int [] dy = {1,0,-1,0};
    static int max;
    static int now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            int n = Integer.parseInt(br.readLine());
            int [][] map = new int[n][n];
            visited = new boolean[n][n];
            max = 0;
            int r = 0, c=0;
            for(int i=0;i<map.length;i++){
                int j=0;
                for(String ch : br.readLine().split(" ")){
                    map[i][j++] = Integer.parseInt(ch);
                }
            }
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map.length;j++){
                    if(!visited[i][j]){
                        int prev =max;
                        now =1;
                        dfs(map, i,j,1);
                        if(max > prev){
                            r = i; c =j;
                        }else if(max == now && (r!=i || c !=j)){
                            int cur= map[i][j];
                            int p = map[r][c];
                            if(cur < p) {r=i; c=j;}
                        }
                    }
                }
            }
            sb.append(map[r][c]+" "+max+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int [][] map, int r, int c, int count){
        int cur = map[r][c];
         for(int d=0;d<4;d++){
            int nx = r+dx[d];
            int ny = c+dy[d];
            if(nx < 0 || ny < 0 || nx>=map.length || ny >= map.length) continue;
            if(!visited[nx][ny] && map[nx][ny] == cur+1){
                visited[nx][ny] = true;
                dfs(map, nx, ny, count+1);
                visited[nx][ny]=false;
            }
        }
        max = Math.max(max, count);
        now = Math.max(now, count);

    }
}
