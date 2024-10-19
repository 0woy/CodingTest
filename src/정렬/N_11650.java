import java.io.*;
import java.time.Period;
import java.util.*;

public class N_11650 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2차원 배열 정렬 다중조건
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            // 첫번째 숫자 기준 오름차순 후 같다면 두번째 숫자 기준 오름차순
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        /*
         * ==
         * Arrays.sort(point, (o1, o2) -> {
         * if (o1[0] == o2[0])
         * return o1[1] - o2[1];
         * else {
         * return o1[0] - o2[0];
         * }
         * });


        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }

    }

}
*/
    static class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n  =Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Position> positions= new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions.add(new Position(x,y));
        }
        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.x==o2.x){
                    return o1.y-o2.y;
                }
                else
                    return o1.x-o2.x;
            }
        });
        for(Position p : positions){
            System.out.println(p.x+" "+p.y);
        }



    }
}