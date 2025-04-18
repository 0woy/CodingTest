package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1956 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        map = new int[v][v];
        for(int [] row: map){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int val = Integer.parseInt(st.nextToken());
            map[start][end] = val;
        }

        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(map[i][k]==Integer.MAX_VALUE ||map[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<v;i++){
            result = Math.min(result, map[i][i]);
        }
        if(result==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(result);


    }
}
