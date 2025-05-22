package DFS_BFS;
import java.util.*;

public class 양과늑대 {
    static List<Integer>[] tree;
    static int maxSheep =0;
    static int [] animalInfo;
    public static int solution(int[] info, int[][] edges) {
        animalInfo = info;
        int n= info.length;

        tree = new List[n];
        for(int i=0;i<n;i++){
            tree[i] = new ArrayList<>();
        }

        for(int [] edge: edges){
            tree[edge[0]].add(edge[1]);
        }

        List<Integer> nextNode =new ArrayList<>();
        nextNode.add(0);
        dfs(0,0,0,nextNode);

        return maxSheep;
    }

    public static void dfs(int cur, int sheep, int wolf, List<Integer> nexts){
        if(animalInfo[cur]==0)sheep++;
        else wolf++;

        if(wolf>=sheep){return;}
        maxSheep = Math.max(sheep, maxSheep);

        List<Integer> candidates = new ArrayList<>(nexts);
        candidates.remove(Integer.valueOf(cur));
        candidates.addAll(tree[cur]);

        for(int next: candidates){
            dfs(next, sheep, wolf, candidates);
        }
    }
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,8},{2,3},{4,5},{4,6},{6,9}};
        solution(info, edges);
    }

}

