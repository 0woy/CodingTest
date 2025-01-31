import java.io.*;
import java.util.StringTokenizer;

public class N_2740 {
    static StringTokenizer st;
    static BufferedReader br;
    public static void initArr(int[][] arr) throws IOException {
        for(int i=0;i<arr.length;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void main(String[] args) throws IOException {
         br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a= new int[n][m];
        initArr(a);

        st = new StringTokenizer(br.readLine()); st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int [][] b = new int[m][k];
        initArr(b);

        for(int r=0;r<n;r++){
            for(int c=0;c<k;c++){
                int total =0;
                for(int idx=0;idx<m;idx++){
                    total += a[r][idx]*b[idx][c];
                }
                bw.write(total+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
//        int [][] res = new int[n][k];



    }
}
