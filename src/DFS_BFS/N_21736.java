package DFS_BFS;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_21736 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int[] start = new int[2];
        for(int i=0;i<n;i++){
            String str= br.readLine();
            int j =0;
            for(char c: str.toCharArray()){
                if(c=='I'){
                    start = new int[]{i,j};
                }
                map[i][j++] = c;
            }
        }

        int res = bfs(start);
        if(res==0){
            System.out.println("TT");
        }else{
            System.out.println(res);
        }

    }
    public static int bfs(int [] start){
        Queue<int[]> que = new ArrayDeque<>();
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};

        que.add(start);
        map[start[0]][start[1]] = '.';
        int person = 0;

        while(!que.isEmpty()){
            int [] tmp = que.poll();
            for(int d=0;d<4;d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];

                if(nx < 0 || ny<0||nx>=map.length|| ny>=map[0].length){
                    continue;
                }
                if(map[nx][ny]=='.' || map[nx][ny]=='X'){
                    continue;
                }
                else if(map[nx][ny]=='O'){
                    map[nx][ny] = '.';
                    que.add(new int[]{nx,ny});
                }
                else{
                    map[nx][ny]='.';
                    person++;
                    que.add(new int[]{nx,ny});
                }
            }
        }
        return person;

    }
}
