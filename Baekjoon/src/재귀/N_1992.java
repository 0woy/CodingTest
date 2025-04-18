import java.io.*;

public class N_1992 {
    static BufferedWriter bw;
    public static void recur(int[][] arr,int row, int col, int len) throws IOException {
        int flag = arr[row][col];
        for(int i=row;i<row+len;i++){
            for(int j=col;j<col+len;j++){
                if(flag!=arr[i][j]){
                    int half = len/2;
                    bw.write("(");
                    recur(arr, row,col,half);
                    recur(arr, row,col+half,half);
                    recur(arr, row+half,col,half);
                    recur(arr, row+half,col+half,half);
                    bw.write(")");
                    return;
                }
            }
        }
        bw.write(flag+"");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];

        for(int i=0;i<arr.length;i++){
            String line = br.readLine();
            int j=0;
            for(char c: line.toCharArray()) {
                arr[i][j++] = c - '0';
            }
        }

        recur(arr, 0,0,arr.length);
        bw.flush();
        bw.close();
    }
}

