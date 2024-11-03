import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2630 {
    private static int res[];
    public static void recur(int [][] map,  int row, int col, int len){
        int flag =  map[row][col];
        if(len == 1){
            res[flag]++;
            return;
        }
        for(int i=row; i<row+len;i++){
            for(int j=col;j<col+len;j++){
                if(flag != map[i][j]){
                    int half = len/2;
                    recur(map, row,col, half);
                    recur(map, row,col+half, half);
                    recur(map, row+half,col, half);
                    recur(map, row+half,col+half, half);
                    return;
                }
            }
        }
        res[flag]++;
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] map  = new int[n][n];
        res = new int[2];
        for(int i=0;i<map.length;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            for(int j=0;j<map[0].length;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(map, 0,0,n);
        System.out.println(res[0]+" "+res[1]);
    }
}
