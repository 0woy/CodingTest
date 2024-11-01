package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1012 {
    static int [] dx =  new int[]{0,1,0,-1};
    static int [] dy =  new int[]{1,0,-1,0};
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            count = Integer.parseInt(st.nextToken());
            Queue<int[]> pos =new ArrayDeque<>();
            arr = new int[row][col];
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[r][c]=1;
                pos.add(new int[]{r,c});

            }
            int res =0;
            while(count >0){
                res+=bfs(pos.poll());
            }
            sb.append(res+"\n");
        }
        System.out.print(sb.toString());
    }
    public static int bfs(int[] pos){
        if(arr[pos[0]][pos[1]]==0){
            return 0;
        }
        count--;
        Queue<int[]> next = new ArrayDeque<>();
        next.add(pos);
        while(!next.isEmpty()){
            int [] tmp = next.poll();
            for(int d=0;d<4;d++){
                arr[tmp[0]][tmp[1]] = 0;
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];

                if(nx<0||nx>=arr.length||ny<0||ny>=arr[0].length){
                    continue;
                }
                if(arr[nx][ny]==1){
                    next.add(new int[]{nx,ny});
                    arr[nx][ny] =0;
                    count--;
                }
            }
        }
        return 1;
    }

}