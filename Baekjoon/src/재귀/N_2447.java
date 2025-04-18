import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N_2447 {
    /** Previous Solve
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void star(int x, int y, int n, boolean blank) {

        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0;

        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }

    }
     */
    static StringBuilder [] star;
    public static void recur(int row, int col, int len){
        int div=len/3;
        for(int i=0;i<div;i++){
            star[row+div+i].replace(col+div, col+div*2, " ".repeat(div));
        }

        if(div==1){ return; }

        recur(row, col, div);
        recur(row, col+div, div);
        recur(row, col+div*2, div);

        recur(row+div, col, div);
        recur(row+div, col+div*2, div);

        recur(row+div*2, col, div);
        recur(row+div*2, col+div, div);
        recur(row+div*2, col+div*2, div);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        star = new StringBuilder[n];
        for(int i=0;i<star.length;i++){
            star[i]= new StringBuilder("*".repeat(n));
        }
        recur(0,0,star.length);
        for(StringBuilder s: star){
            bw.write(s+"\n");
        }
        bw.flush();

    }
}
