package Array;
import java.util.*;
public class 삼각달팽이 {

    public static final int[] dx = {1,0,-1};
    public static final int[] dy = {0,1,-1};
    public int[] solution(int n) {
        int [][] arr= new int[n][n];
        int num=1;
        int x=0;
        int y=0;
        int d =0;
        while(true){
        arr[x][y] = num++;
        int nx = x +dx[d];
        int ny = y +dy[d];
        if(nx==-1 || ny==-1 || nx ==n || ny==n || arr[nx][ny]!=0){
            d =(d+1)%3;
            nx = x +dx[d];
            ny = y +dy[d];
            if(nx==-1 || ny==-1 || nx ==n || ny==n || arr[nx][ny]!=0) break;
        }
        x=nx;
        y=ny;
    }
    int idx =0;int [] res = new int [num-1];
    for(int i=0;i<arr.length;i++){
        for(int j=0; j<=i;j++){
            res[idx++] = arr[i][j];
        }
    }
    return res;
    }
}
