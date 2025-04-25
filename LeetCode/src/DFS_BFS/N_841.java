package DFS_BFS;

import java.util.*;
public class N_841 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> notVisited = new HashSet<>();
        for(int i=0;i<rooms.size();i++){
            notVisited.add(i);
        }
        bfs(notVisited, rooms, 0);
        return notVisited.isEmpty();
    }
    public static void bfs(Set<Integer>notVisited, List<List<Integer>> rooms, int start){
        Queue<Integer> que =new ArrayDeque<>();
        que.add(start);
        notVisited.remove(start);
        while(!que.isEmpty()){
            int next = que.poll();
            for(int v: rooms.get(next)){
                if(notVisited.contains(v)){
                    que.add(v);
                    notVisited.remove(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        canVisitAllRooms(new ArrayList<>(){{
                    add(List.of(1,3));
                    add(List.of(3,0,1));
                    add(List.of(2));
                    add(List.of(0));
        }});
    }
}
