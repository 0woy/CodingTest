import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            boolean [][] map =new boolean[n+1][n+1];
            for(int i=0;i<m;i++){
                int [] pos = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                map[pos[0]][pos[1]] = true;
            }

            for(int k=1;k<=n;k++){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n;j++){
                        map[i][j] = map[i][j] || (map[i][k] && map[k][j]);
                    }
                }
            }
            int ans=0;
            out:
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j) continue;
                    if(!map[i][j] && !map[j][i]) continue out;
                }
                ans++;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

}
