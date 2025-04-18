package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1209 {
    static int max;

    public static void colTotal(int[][] arr){
        for(int i=0;i<arr.length;i++){
            int colTotal =0;
            for(int j=0;j<arr.length;j++){
                colTotal+=arr[j][i];
            }
            max = Math.max(colTotal, max);
        }
    }

    public static void crossTotal(int[][] arr){
        int crossTotal = 0;
        int reverseTotal = 0;
        for(int i=0;i<arr.length;i++){
            crossTotal+=arr[i][i];
            reverseTotal+=arr[i][arr.length-i-1];
        }
            max = Math.max(crossTotal, max);
            max = Math.max(reverseTotal, max);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] arr = new int[100][100];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            int tc = Integer.parseInt(br.readLine());
            sb.append("#"+tc+" ");
            max = Integer.MIN_VALUE;

            for(int i=0;i<100;i++){
                st = new StringTokenizer(br.readLine());
                int j=0;
                int rowTotal = 0;
                while(st.hasMoreTokens()){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowTotal+=arr[i][j++];
                }
                max = Math.max(max, rowTotal);
            }
            colTotal(arr);
            crossTotal(arr);

            sb.append(max+"\n");
            if(tc == 10){
                System.out.println(sb.toString());
                return;
            }
        }
    }
}
