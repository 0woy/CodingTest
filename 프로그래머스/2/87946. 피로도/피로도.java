import java.util.*;
class Solution {
    static int max;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int answer = -1;
        max =Integer.MIN_VALUE;
        visited = new boolean[n];
        
        dfs(dungeons, k, 0);
        return max;
    }
    static void dfs(int [][] arr, int k, int count){
       for(int i=0;i<arr.length;i++){
            if(!visited[i] && k>=arr[i][0]){
                visited[i]=true;
                dfs(arr, k-arr[i][1], count+1);
                visited[i]=false;
            }        
        }
        max = Math.max(max, count);
        return;

    }
}