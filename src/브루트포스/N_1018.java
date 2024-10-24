import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1018 {
    /** Previous Solve
    static boolean[][] board;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(i) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }
        int N_case = N - 7;
        int M_case = M - 7;
        for (int i = 0; i < N_case; i++) {
            for (int j = 0; j < M_case; j++)
                find(i, j);
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int end_n = x + 8;
        int end_m = y + 8;
        int count = 0;
        boolean chess = board[x][y];

        for (int i = x; i < end_n; i++) {
            for (int j = y; j < end_m; j++) {
                if (board[i][j] != chess) {
                    count++;
                }
                chess = !chess;
            }
            chess = !chess;
        }
        count = Math.min(64 - count, count);
        min = Math.min(min, count);
    }
    */
    static char[][] board;
    final static char[][] black= new char[][]{
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };
    public static int paint(int row, int col){
        int biff=0;
        int wiff=0;
        for(int i=0, r=row;r<row+8;r++,i++){
            for(int j=0,c=col;c<col+8;c++,j++){
                if(board[r][c]!=black[i][j]){
                    biff++;
                }
                else{
                    wiff++;
                }
            }
        }
        return Math.min(biff,wiff);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        board = new char[row][col];
        for(int i=0;i<row;i++){
            String r = br.readLine();
            int j=0;
            for(char c: r.toCharArray()){
                board[i][j++] = c;
            }
        }
        row-=8;
        col-=8;
        int res = Integer.MAX_VALUE;
        for(int r=0;r<=row;r++){
            for(int c=0;c<=col;c++){
                res = Math.min(res, paint(r,c));
            }
        }
        System.out.println(res);
    }
}
