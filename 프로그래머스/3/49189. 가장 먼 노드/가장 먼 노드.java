import java.util.*;
class Solution {
    static Map<Integer, Integer> map;
    public int solution(int n, int[][] edge) {
        map = new HashMap<>();
        List<Integer>[] list =new List[n+1];
        for(int i=1;i<=n;i++) list[i] = new ArrayList<>();
        
        for(int [] c: edge){
            int a = c[0];
            int b = c[1];
            list[a].add(b);
            list[b].add(a);
        }
        int maxKey = bfs(1, list);
        return map.get(maxKey);
    }
    
    static int bfs(int start, List<Integer>[] list){
        int max = 0;
        Queue<int[]> que = new ArrayDeque<>();
        boolean [] visited = new boolean[list.length];
        que.offer(new int[]{start, 0});
        visited[start] = true;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            int node = cur[0];
            int depth = cur[1];
            for(int v: list[node]){
                if(!visited[v]){
                    visited[v]=true;
                    max = Math.max(max, depth+1);
                    que.offer(new int[]{v, depth+1});              
                    map.put(depth+1, map.getOrDefault(depth+1, 0)+1);
                }
            }
        }
        return max;
    }
}
















