import java.util.*;
class Solution {
    static final int [] dx = {0,1,0,-1};
    static final int [] dy = {1,0,-1,0};
    static int[] arr;
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        arr =new int[m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1){
                    bfs(land, i, j);
                }
            }
        }
        int answer = 0;
        for(int v: arr) answer = Math.max(answer, v);
        return answer;
    }
    static void bfs(int [][] map, int x, int y){
        Queue<int[]> que = new ArrayDeque<>();
        int min = y;
        int max = y;
        int find = 1;
        que.offer(new int[]{x, y, find});
        map[x][y]=-1;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            for(int d=0;d<dx.length;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                
                if(nx < 0 || ny < 0 || nx >= map.length || ny>= map[0].length)
                    continue;
                if(map[nx][ny]==1){
                    find++;
                    que.offer(new int[]{nx,ny, find});                     
                    min = Math.min(min, ny);
                    max = Math.max(max, ny);
                    map[nx][ny]=-1;
                }
            }
        }
        for(int i=min;i<=max;i++){
            arr[i] += find;
        }
    }
}