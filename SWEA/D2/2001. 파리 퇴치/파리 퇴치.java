import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            map = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                int j=1;
                st= new StringTokenizer(br.readLine());
                int prev =0;
                while (st.hasMoreTokens()){
                    map[i][j] += Integer.parseInt(st.nextToken())+prev;
                    prev = map[i][j];
                    j++;
                }
            }
            int max = findMax(m, n);
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
    static int findMax(int m, int n){
        int max =0;
        for(int e=m;e<=n;e++){
            int s =e-m;
            for(int r=m;r<=n;r++){
                int total =0;
                for(int j=r;j>r-m;j--){
                    total+=map[j][e];
                    total -= map[j][s];
                }
                max= Math.max(max, total);

            }
        }
        return max;
    }
}
