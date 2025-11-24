import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int max =triangle[0][0];
        int n = triangle.length-1;        
        for(int i=1;i<=n;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0) {triangle[i][j] +=triangle[i-1][j];} 
                else if(j==triangle[i].length-1){{triangle[i][j] +=triangle[i-1][j-1];} }
                else{
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j])
                        +triangle[i][j];
                }
                
            }
        }
        for(int v: triangle[n]){
            max = Math.max(max, v);
        }
        
        
        return max;
    }
}