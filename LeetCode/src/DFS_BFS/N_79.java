package DFS_BFS;

import java.util.Arrays;

public class N_79 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static boolean bfs(char[][] board, String word,int r, int c, int w){
        if(w>=word.length()){
            return true;
        }
        for(int d=0;d<4;d++){
            int nx = r+dx[d];
            int ny = c+dy[d];
            if(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length){
                if(board[nx][ny]==word.charAt(w)){
                    board[nx][ny] = '.';
                    boolean tmp = bfs(board, word,nx, ny,w+1);
                    if(tmp)
                        return tmp;
                    else
                        board[nx][ny] = word.charAt(w);
                }
            }
        }
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c] == word.charAt(0)){
                    board[r][c]='.';
                   boolean res =  bfs(board, word, r,c,1);
                    if(res){
                        return true;
                    }
                    board[r][c] = word.charAt(0);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
       char[][] board = new char[][]{
                {'a','a'}
        };

       String  word = "aaa";
        exist(board, word);
    }
}
