package DP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class N_64 {
    /**
    public static int minPathSum(int[][] grid) {
        int [] dx = new int[]{0,1};
        int [] dy = new int[]{1,0};

        int [][] dp = new int[grid.length][grid[0].length];
        Queue<int[]> pos =new ArrayDeque<>();
        pos.add(new int[]{0,0});
        while (!pos.isEmpty()){
            int [] cur =pos.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0;d<2;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx <0|| ny<0 || nx>=grid.length || ny>=grid[0].length){
                    continue;
                }
                if(dp[nx][ny]==0){
                    dp[nx][ny] = Math.min(dp)
                }
            }
        }
        return 1;
    }
     */

    public static int minPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int len = Math.min(n,m);


        for(int j=1;j<m;j++){
            grid[0][j] +=  grid[0][j-1];
        }
        for(int i=1;i<n;i++){
            grid[i][0] +=  grid[i-1][0];
        }

        for(int k=1;k<n;k++){
            for(int j=1;j<m;j++){
                grid[k][j] = Math.min(grid[k-1][j], grid[k][j-1])+grid[k][j];
            }
        }
        System.out.println( grid[n-1][m-1]);
        return grid[n-1][m-1];
    }
    public static void main(String[] args) {
        int [][] grid =new int[][]{
                {1,2},
                {5,6},
                {1,1}
        };

        minPathSum(grid);
    }
}
