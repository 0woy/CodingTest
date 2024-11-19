package Arrays_Hashing;

import java.util.*;

public class N_207 {
    /** Wrong
    static boolean [] visited;
    static Map<Integer, List<Integer>> map;
    static boolean res;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        res = true;
        map =new HashMap<>();
        for(int [] pre: prerequisites){
            List<Integer> tmp = map.getOrDefault(pre[0], new ArrayList<>());
            tmp.add(pre[1]);
            map.put(pre[0],tmp);
        }
        for(int i=0;i<numCourses;i++){
            visited = new boolean[numCourses];
            if(!visited[i] && map.containsKey(i)){
                for(int v : map.get(i)){
                    dfs(v);
                    visited[i]=true;
                }
            }
            if(!res){
                System.out.println(res);
                return false;
            }
        }
        System.out.println(res);
        return res;
    }
    public static void dfs(int cur){
        if(map.get(cur)==null){
            return;
        }
        if(!visited[cur]){
            visited[cur]=true;
            for(int v: map.get(cur)){
                dfs(v);
            }
            if(!res){
                return;
            }
        }else{
            res = false;
        }
    }
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list =new List[numCourses];
        List<Integer> res = new ArrayList<>();
        int [] indegree = new int[numCourses];
        for(int [] pair : prerequisites){
            int after  =pair[0];
            int before = pair[1];
            if(list[before]==null){
                list[before] = new ArrayList<>();
            }
            list[before].add(after);
            indegree[after]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            res.add(cur);

            if(list[cur]!=null){
                for(int v: list[cur]){
                    indegree[v]--;
                    if(indegree[v]==0){
                        que.offer(v);
                    }
                }
            }
        }
        System.out.println( res.size() == numCourses);
        return res.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 8;
        int [][] prerequisites = new int[][]{
                {1,0},
                {2,6},
                {1,7},
                {6,4},
                {7,0},
                {0,5}
        };

        canFinish(numCourses, prerequisites);
    }
}
