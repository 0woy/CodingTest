package DFS_BFS;
import java.util.*;
public class 미로탈출 {
    final static int [] dx = {0,1,0,-1};
    final static int [] dy = {1,0,-1,0};
    static boolean [][] visited;
    static int total;

    public static int solution(String[] maps) {
        int [] start = null;
        int [] lever = null;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new int[]{i,j};
                }
                if(maps[i].charAt(j) == 'L'){
                    lever = new int[]{i,j};
                }
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        total =0;
        if(!bfs(start[0],start[1], maps, 'L')){
            return -1;
        }
        visited = new boolean[maps.length][maps[0].length()];
        if(!bfs(lever[0],lever[1], maps, 'E')){
            return -1;
        }
        System.out.println(total);
        return total;
    }

    public static boolean bfs(int x, int y, String[]maps, char goal){
        Queue<int[]> que =new ArrayDeque<>();
        que.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!que.isEmpty()){
            int len = que.size();
            total++;
            for(int i=0;i<len;i++){
                int [] cur = que.poll();
                for(int d=0;d<4;d++){
                    int nx= cur[0]+dx[d];
                    int ny= cur[1]+dy[d];

                    if(nx < 0 || ny<0 || nx>=maps.length || ny>=maps[0].length()){
                        continue;
                    }

                    if(!visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                        if(maps[nx].charAt(ny)==goal){
                            return true;
                        }
                        que.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solution(new String[]{
                "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"
        });
    }
}
