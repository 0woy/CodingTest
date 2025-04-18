package Array;
import java.util.*;

public class 거리두기확인하기 {
    class Solution {
        static boolean [][] visited;
        static  int [][] count;
        public class Point{
            int x, y;
            public Point(int x, int y){
                this.x = x;
                this.y =y;
            }
            public int[] getPos(){
                return new int[]{this.x, this.y};
            }
        }

        public static boolean bfs(int[][] arr, Point p){
            visited = new boolean[5][5];

            Queue<int[]> que = new ArrayDeque<>();
            int [] pos = p.getPos();
            que.offer(new int[]{pos[0], pos[1]});
            visited[pos[0]][pos[1]] = true;

            int [] dx = new int[]{0,1,0,-1};
            int [] dy = new int[]{1,0,-1,0};

            while(!que.isEmpty()){
                int[] tmp = que.poll();
                for(int d=0;d<4;d++){   // 현 위치에서 상하좌우 이동
                    int nx = tmp[0] + dx[d];
                    int ny = tmp[1] + dy[d];

                    if(nx>=0 && ny>=0 && nx<5&& ny<5){
                        if(!visited[nx][ny] && (arr[nx][ny]==1 || arr[nx][ny]==0)){

                            if(arr[nx][ny] == 1){ // O
                                count[nx][ny] = count[tmp[0]][tmp[1]]+1;
                            }

                            if(arr[nx][ny] == 0){   // p
                                count[nx][ny] = count[tmp[0]][tmp[1]]+1;
                                if(count[nx][ny] <=2) return false;
                            }
                            visited[nx][ny]= true;
                            que.offer(new int[]{nx,ny});
                        }
                    }
                }
            }

            return true;
        }
        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            int [][] tmp = new int[5][5];
            List<Point> points = new ArrayList<>();

            for(int i=0;i<5;i++){
                points.clear();
                for(int j=0;j<5;j++){
                    String str = places[i][j];
                    for(int k=0; k<str.length();k++){
                        switch(str.charAt(k)){
                            case 'P':
                                tmp[j][k]= 0;
                                break;

                            case 'O':
                                tmp[j][k]= 1;
                                break;

                            case 'X':
                                tmp[j][k] = -1;
                                break;
                        }
                        if(tmp[j][k] == 0)
                            points.add(new Point(j,k));
                    }
                }

                boolean check = true;


                for(int p=0;p<points.size();p++){
                    count = new int[5][5];
                    check = bfs(tmp, points.get(p));
                    if(!check){
                        answer[i] = 0;
                        break;
                    }
                }
                if(check) answer[i]=1;
            }

            return answer;

        }
    }

}
