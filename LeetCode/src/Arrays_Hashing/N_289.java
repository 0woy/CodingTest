package Arrays_Hashing;


import java.util.ArrayList;
import java.util.List;

public class N_289 {
    /** Space Complexity: O(N²)
    static List<int[]> change;
    static final int[] dx = new int[]{0,1,1,1,0,-1,-1,-1}; // 우측부터 시계방향
    static final int[] dy = new int[]{1,1,0,-1,-1,-1,0,1};

    public static boolean isStateChange(int cur,int nlives){
        if(cur==1){
            return nlives < 2 || nlives > 3;
        }
        return nlives == 3; // 죽은 세포의 경우
    }
    public static void gameOfLife(int[][] board) {
         change = new ArrayList<>();
         
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                int cur = board[r][c];
                int nlives = 0;
                for(int d=0;d<dx.length;d++){
                    int nx = r+dx[d];
                    int ny = c+dy[d];
                    if(nx<0||ny<0||nx>=board.length||ny>=board[0].length){
                        continue;
                    }
                    if(board[nx][ny]==1){
                        nlives++;
                    }
                }
                if((cur==1 && (nlives < 2 || nlives > 3))|| (cur==0 && nlives==3)) {
                    change.add(new int[]{r, c});
                }
            }
        }

        for(int[] idx : change){
            int r = idx[0];
            int c = idx[1];
            board[r][c] = board[r][c]==1?0:1;
        }
    }
     */

    static final int[] dx = new int[]{0,1,1,1,0,-1,-1,-1}; // 우측부터 시계방향
    static final int[] dy = new int[]{1,1,0,-1,-1,-1,0,1};
    public static void gameOfLife(int[][] board) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                int cur = board[r][c];
                int nlives = 0;
                for(int d=0;d<dx.length;d++){
                    int nx = r+dx[d];
                    int ny = c+dy[d];
                    if(nx<0||ny<0||nx>=board.length||ny>=board[0].length){
                        continue;
                    }
                    if(Math.abs(board[nx][ny])==1){
                        nlives++;
                    }
                }
                if(cur == 1 && (nlives<2 || nlives>3)){
                    board[r][c] = -1;
                }
                if(cur==0 && nlives==3){
                    board[r][c] =2;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j]=0;
                }
                else if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] board = {
                {1,1},
                {1,0}
        };
        gameOfLife(board);
    }

}
