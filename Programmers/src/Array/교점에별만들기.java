package Array;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {
    /** Runtime Error
    public static List<long[]> position;
    static int yMax;
    static int xMax;
    static int yMin;
    static int xMin;
    public static String[] solution(int[][] line) {
        StringBuilder[] answer = {};
        yMax = Integer.MIN_VALUE;
        xMax = Integer.MIN_VALUE;
        yMin = Integer.MAX_VALUE;
        xMin = Integer.MAX_VALUE;

        position = new ArrayList<>();
        for(int i=0;i<line.length;i++){
            calc(i+1, line);
        }

        answer = new StringBuilder[yMax - yMin+1];
        for(int i=0;i<answer.length;i++){
            answer[i] = new StringBuilder(".".repeat(xMax-xMin+1));
        }
        for(long [] pos : position){
            long x = pos[0]+xMax;
            long y = Math.abs(pos[1]-yMax);
            answer[(int) y].setCharAt((int)x,'*');
        }
        for(StringBuilder cur: answer){
            System.out.println(cur);
        }
        return Arrays.stream(answer).map(StringBuilder::toString).toArray(String[]::new);
    }
    public static void calc(int start, int[][] line){
         int a1 = line[start-1][0];
         int b1 = line[start-1][1];
         int c1 = line[start-1][2];

         for(int i=start;i<line.length;i++){
             int a2= line[i][0];
             int b2= line[i][1];
             int c2= line[i][2];
             if((a1*b2-a2*b1)==0 ||(a1*b2-a2*b1)==0
                     ||(b1*c2-b2*c1)%(a1*b2-a2*b1)!=0 || (c1*a2-c2*a1)%(a1*b2-a2*b1)!=0 ){
                 continue;
             }
             long x = (b1*c2-b2*c1)/(a1*b2-a2*b1);
             long y = (c1*a2-c2*a1)/(a1*b2-a2*b1);
             yMax = (int) Math.max(yMax, y);
             xMax = (int) Math.max(xMax, x);
             yMin = (int) Math.min(yMin, y);
             xMin = (int) Math.min(xMin, x);
             position.add(new long[]{x,y});

         }
    }

    public static void main(String[] args) {
        int [][] line = new int[][]{
                {1, -1, 0}, {2, -1, 0}
        };
        solution(line);
    }
     */
    private static class Point{
        public final long x, y;
        private Point(long x, long y){
            this.x=x;
            this.y=y;
        }

    }
    private Point inter(long a1, long a2, long b1, long b2, long c1, long c2){
        double x = (double) (b1*c2)-(c1*b2)/(a1*b2)-(b1*a2);
        double y = (double) (a2*c1)-(a1*c2)/(a1*b2)-(b1*a2);
        if(x%1!=0 || y%1!=0){
            return null;
        }
        return new Point((long)x, (long) y);
    }

    private Point getMinPoint(List<Point> points){
        long x =  Long.MAX_VALUE;
        long y =  Long.MAX_VALUE;

        for(Point p: points){
            x = Math.min(p.x,x);
            y = Math.min(p.y,y);
        }
        return new Point(x,y);
    }

    private Point getMaxPoint(List<Point> points){
        long x =  Long.MIN_VALUE;
        long y =  Long.MIN_VALUE;

        for(Point p: points){
            x = Math.max(p.x,x);
            y = Math.max(p.y,y);
        }
        return new Point(x,y);
    }
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i=0;i<line.length;i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point inters = inter(
                        line[i][0], line[j][0],
                        line[i][1], line[j][1],
                        line[i][2], line[j][2]
                );
                if (inters != null) {
                    points.add(inters);
                }
            }
        }
            Point max =getMaxPoint(points);
            Point min =getMinPoint(points);
            int width = (int) (max.x-min.x+1);
            int height = (int) (max.y-min.y+1);

            char [][] arr =new char[width][height];
            for( char[] row: arr){
                Arrays.fill(row,'.');
            }

            for(Point p: points){
                int x = (int) (p.x-min.x);
                int y =(int)(max.y-p.y);
                arr[y][x] = '*';
            }
           String[] answer = new String[arr.length];
            for(int i=0;i< answer.length;i++){
                answer[i] = new String(arr[i]);
            }
            return answer;
    }

    public static void main(String[] args) {

    }
}
