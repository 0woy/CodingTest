package Arrays_Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_210 {
    static List<List<Integer>> list;
    static Stack<Integer> stack;
    static boolean [] visited;
    static boolean [] finish;
    static boolean cycle;
    public static int[]canFinish(int numCourses, int[][] prerequisites) {
        list =new ArrayList<>();
        stack = new Stack<>();
        visited = new boolean[numCourses];
        finish = new boolean[numCourses];
        cycle =false;

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int [] pair: prerequisites){
            int after= pair[0];
            int before= pair[1];
            list.get(before).add(after);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        int [] res = new int[numCourses];
        if(!cycle){
            int idx =0;
            while(!stack.isEmpty()){
                res[idx++] = stack.pop();
            }
        }
        else{
            return res;
        }
        System.out.println(true);
        return res;
    }
    public static void dfs(int cur){
        if(cycle){
            return;
        }
        visited[cur] = true;
        for(int next : list.get(cur)){
            if(!visited[next]) {
                dfs(next);
            }
            else if(!finish[next]){
                cycle = true;
                return;
            }
        }
        finish[cur]=true;
        stack.push(cur);
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = new int[][]{
                {1,0},
                {0,1}
        };

        canFinish(numCourses, prerequisites);
    }
}
