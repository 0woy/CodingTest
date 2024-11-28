package DFS_BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class N_2667 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            String str =br.readLine();
            int j =0;
            for(char c: str.toCharArray()){
                arr[i][j++] = c-'0';
            }
        }

        int total =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    arr[i][j]=0;
                    que.add(bfs(i,j));
                    total++;
                }
            }
        }
        bw.write(total+"\n");
        while(!que.isEmpty()){
            bw.write(que.poll()+"\n");
        }
        bw.flush();
        bw.close();

    }
    public static int bfs(int r, int c){
        Queue<int[]> que = new ArrayDeque<>();
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};

        que.add(new int[]{r,c});

        int count =1;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];

                if(nx<0 || ny<0 || nx>=arr.length || ny >=arr.length){
                    continue;
                }
                if(arr[nx][ny]==1){
                    arr[nx][ny]=0;
                    que.add(new int[]{nx,ny});
                    count++;
                }
            }
        }
        return count;
    }
}
