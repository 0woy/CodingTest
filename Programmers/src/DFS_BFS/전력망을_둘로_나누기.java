package DFS_BFS;

import java.util.*;

public class 전력망을_둘로_나누기 {
    static List<Integer>[] arr;
    public static int solution(int n, int[][] wires) {
        int answer = n;
        arr = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] e : wires) {
            arr[e[1]].add(e[0]);
            arr[e[0]].add(e[1]);
        }
        for (int[] edge : wires) {
            int a = edge[0];
            int b = edge[1];
            boolean[] visited = new boolean[n + 1];

            int count = dfs(a,b,visited);
            answer =Math.max(answer,count);
        }
        return answer;
    }

    public static int dfs(int cur,int blocked, boolean[] visited) {
        visited[cur] = true;
        int res =1;
        for (int n : arr[cur]) {
            if(!visited[n] && n !=blocked) {
                res += dfs(n, blocked, visited);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution(7, new int[][]{
                {1,2},
                {2,7},
                {3,7},
                {3,4},
                {4,5},
                {6,7},
        });
    }
}

