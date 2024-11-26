package DFS_BFS;

import java.util.*;

public class N_909 {
    /** 머리가 나쁘면 코드 100줄 침
    static class State{
        Position position;
        int rolls;
        State(Position position, int rolls){
            this.position=position;
            this.rolls=rolls;
        }
    }
    static List<Position> valBoard;
    static int n;
    static class Position{
        int r, c;
        int val;
        boolean visited;

        public Position(int r, int c){
            this.r = r;
            this.c = c;
            this.val = curVal(r,c);
            this.visited = false;
        }
    }
    public static int curVal(int row, int col){
        int minus =-1;
        if(n%2==0){
            if(row%2!=0){
                minus=(n-col-1);
            }else{
                minus = col;
            }
        }else{
            if(row%2!=0){
                minus = col;
            }else{
                minus=(n-col-1);
            }
        }
        return n*(n-row) - minus;
    }
    public static int snakesAndLadders(int[][] board) {
         n = board.length;
         valBoard = new ArrayList<>();
         for(int i=n-1;i>=0;i--){
             if(n%2!=0){
                 if(i%2!=0){
                     for(int j=n-1;j>=0;j--){
                         valBoard.add(new Position(i,j));
                     }
                 }else{
                     for(int j=0;j<n;j++){
                     valBoard.add(new Position(i,j));
                     }
                 }
             }else{
                 if(i%2!=0){
                     for(int j=0;j<n;j++){
                         valBoard.add(new Position(i,j));
                     }
                 }else{
                     for(int j=n-1;j>=0;j--){
                         valBoard.add(new Position(i,j));
                     }
                 }
             }
         }

         int res =bfs(board);
        System.out.println(res);
        return res;
    }
    public static int bfs(int [][] board){
        Queue<State> que = new ArrayDeque<>();
        int [] dice = new int[]{1,2,3,4,5,6};
        que.add(new State(valBoard.get(0),0)); // start;
        valBoard.get(0).visited=true;

        while(!que.isEmpty()){
            State state = que.poll();
            Position cur = state.position;
            int rolls = state.rolls;
            for(int d =0;d<dice.length;d++){
                int nIdx = cur.val+dice[d]-1;
                if(nIdx >= n*n){
                    nIdx = n*n-1;
                }
                Position next = valBoard.get(nIdx);
                if(!next.visited){
                    if(next.val==n*n){
                        return rolls+1;
                    }
                    if (board[next.r][next.c]!= -1) {
                        if(board[next.r][next.c]==n*n){
                            return rolls+1;
                        }
                        valBoard.get(nIdx).visited=true;
                        que.add(new State(valBoard.get(board[next.r][next.c]-1),rolls+1));
                    }else{
                        valBoard.get(nIdx).visited=true;
                        que.add(new State(next, rolls+1));
                    }
                }
            }

        }

        return -1;
    }
     */

    static int n;
    public static int snakesAndLadders(int[][] board) {
        n = board.length;
        int [] flat = new int[n*n+1];
        boolean LtoR = true;
        int idx =1;
        for(int i=n-1; i>=0;i--){
            if(LtoR){
                for(int j=0;j<n;j++){
                    flat[idx++] = board[i][j];
                }
            }else{
                for (int j=n-1;j>=0;j--){
                    flat[idx++] = board[i][j];
                }
            }
            LtoR = !LtoR;
        }
        int res = bfs(flat);
        System.out.println(res);
        return res;
    }
    public static int bfs(int [] flat){
        Queue<Integer> que = new ArrayDeque<>();
        boolean [] visited = new boolean[n*n+1];
        que.add(1);
        visited[1] = true;
        int count =0;
        while (!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int cur = que.poll();
                if(cur == n*n){
                    return count;
                }
                for(int dice =1; dice<=6;dice++){
                    int next = cur+dice;
                    if(next > n*n){
                        break;
                    }
                        if(flat[next] != -1){// labber or snake
                            next = flat[next];
                        }
                        if(!visited[next]){
                            visited[next]=true;
                            que.add(next);
                        }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args){
        int [][] board =new int[][]{
                {1,1,-1},
                {1,1,1},
                {-1,1,1},
        };
//        int [][] board =new int[][]{
//                {-1,-1},
//                {-1,3}
//        };

        snakesAndLadders(board);
    }

}
