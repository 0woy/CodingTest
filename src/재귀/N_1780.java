import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1780 {

    static int[] count;
    static int [][] arr;
    public static void recur(int row, int col, int len){
        if(len==1){
            count[arr[row][col]+1]++;
            return;
        }

        int flag = arr[row][col];
        int div = len/3;
        for(int i=row;i<row+len;i++){
            for(int j=col;j<col+len;j++){
                if(flag!=arr[i][j]){
                    for(int r=row;r<row+len;r +=div){
                        for(int c=col;c<col+len;c+=div){
                            recur(r,c,div);
                        }
                    }
                    return;
                }
            }
        }
        count[flag+1]++;
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        count = new int[3];
        for(int i=0;i<arr.length;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<arr.length;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0,n);
        for (int v:count){
            System.out.println(v);
        }

    }
}
