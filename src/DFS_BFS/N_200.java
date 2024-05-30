package DFS_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 문제 설명
Given an m x n 2D binary grid
grid represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class N_200 {
    /** bfs
    public static boolean visited[][];
    public static Queue<int []> land;
    public static void bfs(char[][] grid){
        int [] dx = new int[]{1,0,-1,0};
        int [] dy = new int[]{0,1,0,-1};
        while(!land.isEmpty()){
            int[] cur = land.poll();
            visited[cur[0]][cur[1]] = true;
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(nx<0 || ny<0|| nx>=grid.length||ny>=grid[0].length){
                    continue;
                }
                else {
                    if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        land.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        visited = new boolean[grid.length][grid[0].length];
        land = new ArrayDeque<>();
        int total = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]=='1' && !visited[i][j]){
                  land.add(new int []{i,j});
                    bfs(grid);
                    total++;
              }
            }
        }
        System.out.println(total);
    }
     */

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int landNum =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    landNum++;
                    dfs(grid, i,j);
                }
            }
        }
        System.out.println(landNum);
    }
    public static void dfs(char [][]grid, int row, int col){
        if(row<0||row>=grid.length||col<0||col>=grid[0].length|| grid[row][col]!='1'){
            return;
        }
        grid[row][col] = '0';
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row,col-1);
    }
}
