package DFS_BFS;
import java.util.*;

public class 가장_먼_노드 {
    static Set<Integer> notVisited;
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        notVisited = new HashSet<>();
        for(int [] connect: edge){
            int a = connect[0];
            int b = connect[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
            notVisited.add(a);
            notVisited.add(b);
        }
        int total = notVisited.size();
        return bfs(1,graph, total);
    }
    public static int bfs(int start, Map<Integer, List<Integer>> g, int total){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        notVisited.remove(start);
        while(!que.isEmpty()){
            int len = que.size();
            total -=len;
            if(total==0){return len;}
            for(int i=0;i<len;i++){
                int next= que.poll();
                for(int v: g.get(next)){
                    if(notVisited.contains(v)){
                        notVisited.remove(v);
                        que.add(v);
                    }
                }
            }
        }
        return 0;
    }

}
