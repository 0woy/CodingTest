import java.util.*;
/**

load 클래스: x, y, nx, ny -> equals =  
(0,0) -> (1,0), (1,0)->(0,0)
x,y -> nx, ny || another.nx == x || another.x == x
*/
class Solution {
    class Load{
        int x;
        int y;
        int nx;
        int ny;
        public Load(int x, int y, int nx, int ny){
            this.x =x;
            this.y =y;
            this.nx = nx;
            this.ny = ny;
        }
        @Override
        public boolean equals(Object obj){
            if(obj==null || getClass()!=obj.getClass()) return false;
            Load l = (Load) obj;
            return (x ==l.x && y==l.y && nx == l.nx && ny == l.ny) ||
                (x ==l.nx && y==l.ny && nx == l.x && ny == l.y);
        }
        
        @Override
        public int hashCode(){
            int[] points = {x, y, nx, ny};
             Arrays.sort(points); // 순서를 정렬하여 동일한 경로에 대해 동일한 해시값을 반환
            return Objects.hash(points[0], points[1], points[2], points[3]);
        }
    }
    static int [][] map;
    public int solution(String dirs) {
        map = new int[11][11];
        Set<Load> set = new HashSet<>();
        int x =5, y=5;
        for(char d: dirs.toCharArray()){
            Load line = nextPos(d,x,y);
            if(line == null) continue;
            int nx = line.nx;
            int ny = line.ny;
            set.add(line);
            x = line.nx;
            y = line.ny;
        }
        return set.size();
    }
    
    public Load nextPos(char d, int x, int y){
        int nx = x;
        int ny =y;
        if(d =='L' && ny-1 >=0 && ny-1<map.length) return new Load(x,y,nx,ny-1);
        else if(d =='U' && nx-1 >=0 && nx-1<map.length) return new Load(x,y,nx-1,ny);
        else if(d =='R' && ny+1 >=0 && ny+1<map.length) return new Load(x,y,nx,ny+1);
        else if(d =='D' && nx+1 >=0 && nx+1<map.length) return new Load(x,y,nx+1,ny);
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
