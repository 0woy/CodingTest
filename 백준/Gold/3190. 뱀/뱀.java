import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class Main{
    static int[][] map;
    static Queue<Change> change;
    final static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static class Change {
        int sec;
        char dir;
        public Change(int s, char d) {
            this.sec = s;
            this.dir = d;
        }
    }

    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            Position position = (Position) object;
            return x == position.x && y == position.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    static int[] nextDir(int[] cur, char dir) {
        int pos = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i][0] == cur[0] && direction[i][1] == cur[1]) {
                pos = i;
                break;
            }
        }
        pos = (dir=='L')?(pos+3)%4:(pos+5)%4;
        return direction[pos];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int apple = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        change = new ArrayDeque<>();
        for (int i = 0; i < apple; i++) {
            String[] line = br.readLine().split(" ");
            map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] dir = br.readLine().split(" ");
            change.offer(new Change(Integer.parseInt(dir[0]), dir[1].charAt(0)));
        }

        int[] cdir = direction[0];
        System.out.println(run(cdir)+1);
    }
    static int run(int[] dir){
        int total =0;
        ArrayDeque<Position> que = new ArrayDeque<>();
        que.offer(new Position(1,1));

        while (!que.isEmpty()){
            Position cur = que.peekLast();
            int nx = cur.x +dir[0];
            int ny = cur.y+dir[1];
            Position next= new Position(nx, ny);
            if(que.contains(next)||nx<=0 || ny<=0 || nx>=map.length||ny>=map.length){
                return total;
            }
            if(map[nx][ny]==0){que.pollFirst();}
            else{map[nx][ny]=0;}
            que.add(next);
            total++;

            if(change.peek()!=null &&change.peek().sec == total){
                Change c = change.poll();
                dir = nextDir(dir, c.dir);
            }
        }
        return total;
    }
}
