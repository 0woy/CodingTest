
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_15686 {
    static  List<Position> house;
    static List<Position> chicken;
    static boolean[] visited;
    static int[] selected;
    static int total;
    public static class Position{
        int x,y;
        int min;
        public Position(){}
         public Position(int x, int y){
            this.x=x;
            this.y=y;
            min = Integer.MAX_VALUE;
        }
        public int calc(Position another){
            return Math.abs(this.x-another.x)+Math.abs(this.y-another.y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1){
                    house.add(new Position(i,j));
                }else if(cur == 2){
                    chicken.add(new Position(i,j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        selected = new int[m];
        total=Integer.MAX_VALUE;
        dfs(m, 0,0);
        System.out.println(total);
    }
    public static void dfs(int m, int depth, int start){
        if(m==depth){
            int count=0;
            for(Position h: house){
                for(int idx : selected){
                    h.min= Math.min(h.min, h.calc(chicken.get(idx)));
                }
                count+=h.min;
                h.min = Integer.MAX_VALUE;
            }
            total = Math.min(total, count);
            return;
        }
        for(int i=start;i<chicken.size();i++){
            if(!visited[i]){
                visited[i]=true;
                selected[depth] = i;
                dfs(m, depth+1,i+1);
                visited[i]=false;
            }
        }

    }
}
