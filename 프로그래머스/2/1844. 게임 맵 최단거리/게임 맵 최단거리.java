import java.util.*;
class Solution {
    static final int [] dx = {0,1,0,-1};
    static final int [] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    static int bfs(int [][] maps){
       Queue<int[]> que = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        que.offer(new int[]{0,0,1});
        visited[0][0]=true;
        
        while(!que.isEmpty()){
            int [] cur = que.poll();
            if(cur[0] == n-1 && cur[1] == m-1) return cur[2];
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];                
                
                if(nx>=0 && ny>=0 && nx<n && ny<m && maps[nx][ny]==1){
                    if(!visited[nx][ny]){
                        visited[nx][ny]= true;
                        que.offer(new int[]{nx,ny, cur[2]+1});
                    }
                }                                
            }                        
        }
        return -1;
        
    }
}