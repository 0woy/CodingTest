import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int count =1;
        int flag= routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(flag < routes[i][0]){
                flag = routes[i][1];
                count++;
            }
        }
        return count;
    }
}