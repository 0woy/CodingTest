package DFS_BFS;

import java.io.*;
import java.util.*;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        boolean[][] visited= new boolean[maps.length][maps[0].length];
        int answer = bfs(maps, visited, 0,0);
        return answer;
    }

    static int bfs(int[][] maps, boolean [][] visited, int x, int y){
        Queue<int[]> que = new ArrayDeque<>();
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};

        que.offer(new int[]{x,y});
        visited[x][y] = true;
        int count = 0;

        while(!que.isEmpty()){
            int [] tmp = que.poll();
            for(int d=0;d<4;d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx>=0 && ny >=0 && nx<maps.length&&ny<maps[0].length){
                    if(!visited[nx][ny]&&maps[nx][ny]==1){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[tmp[0]][tmp[1]]+1;
                        que.offer(new int[]{nx,ny});
                        if(nx == maps.length -1 && ny == maps[0].length -1){
                            return maps[nx][ny];
                        }
                    }

                }
            }
        }
        return -1;
    }

}
