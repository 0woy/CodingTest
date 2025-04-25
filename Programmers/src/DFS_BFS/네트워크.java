package DFS_BFS;
import java.util.*;
public class 네트워크 {
    static boolean [] visited;
    public int solution(int n, int[][] computers) {
        Set<Integer> notVisited = new HashSet<>();
        for(int i=0;i<computers.length;i++){
            notVisited.add(i);
        }
        int answer = 0;
        for(int i=0;i<computers.length;i++){
            if(notVisited.contains(i)){
                answer++;
                dfs(computers, i, notVisited);
            }
        }
        return answer;
    }
    public static void dfs(int[][] computers, int cur, Set<Integer> notVisited){
        notVisited.remove(cur);
        for(int i=0;i<computers.length;i++){
            if(computers[cur][i]==1 && notVisited.contains(i)){
                dfs(computers, i, notVisited);
            }
        }
    }

    public static void bfs(int [][] computers, int start){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start]=true;
        while(!que.isEmpty()){
            int next =que.poll();
            for(int i=0;i<computers.length;i++){
                if(computers[next][i]==1&&!visited[i]){
                    que.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
