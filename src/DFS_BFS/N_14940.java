package DFS_BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_14940 {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        int[] start  =new int[2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    start[0]=i;
                    start[1]=j;
                }
                j++;
            }
        }
        bfs(start);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]!=0){
                    bw.write(-1+" ");
                }else{
                    bw.write(map[i][j]+" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void bfs(int [] start){
        Queue<int[]> que =new ArrayDeque<>();
        int [] dx =new int[]{0,1,0,-1};
        int [] dy =new int[]{1,0,-1,0};
        que.add(start);
        map[start[0]][start[1]]=0;
        visited[start[0]][start[1]]=true;

        while(!que.isEmpty()){
            int size = que.size();
            while(size -- >0){
                int [] cur = que.poll();
                for(int d=0;d<4;d++){
                    int nx = cur[0]+dx[d];
                    int ny = cur[1]+dy[d];

                    if(nx < 0|| ny<0||nx>=map.length||ny>=map[0].length){
                        continue;
                    }
                    if(map[nx][ny]==0){
                        visited[nx][ny]= true;
                        continue;
                    }
                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        map[nx][ny] = map[cur[0]][cur[1]]+1;
                        que.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
