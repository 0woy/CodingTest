package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc =Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int [n][n];
            for(int i=0;i<n;i++){
                int j =0;
                StringBuilder row = new StringBuilder(br.readLine());
                for(char v : row.toString().toCharArray()) {
                    arr[i][j++] = v - '0';
                }
            }
            int range =1;
            int mid = arr.length/2;
            int total = 0;
            for(int i=0;i<arr.length;i++){
                total += arr[i][mid];
            }
            for(int i=1;i<arr.length-1;i++){
                for(int r =1;r<=range;r++){
                    total = total+arr[i][mid+r]+arr[i][mid-r];
                }
                range = (i<mid) ? range+1:range-1;
            }
            sb.append(total+"\n");
        }
        System.out.println(sb);
    }
}
