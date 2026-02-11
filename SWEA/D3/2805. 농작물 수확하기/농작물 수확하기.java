import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[][] map;

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (char v : br.readLine().toCharArray()) {
                    map[i][j] = v - '0';
                    total += map[i][j];
                    j++;
                }
            }
            
            int len = n / 2;
            int [] points = {0,n-1};
            for(int x: points){
                for(int y:points){
                    int iStart = (x==0)?0:n-len;
                    int iEnd = (x==0)?len:n;
                    int jStart = (y==0)?0:n-len;
                    int jEnd = (y==0)?len:n;

                    for(int i=iStart;i<iEnd;i++){
                        for(int j=jStart;j<jEnd;j++){
                            if(Math.abs(i-x)+Math.abs(j-y)<len) total-=map[i][j];
                        }
                    }
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }

}
