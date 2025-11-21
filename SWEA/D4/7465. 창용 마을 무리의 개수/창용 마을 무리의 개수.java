import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    static int[] root;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t+ " ");
            int [] val = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = val[0];
            int m = val[1];
            root = new int[n+1];
            rank = new int[n+1];
            for(int i=0;i<=n;i++){
                root[i]=i;
            }
            for(int i=0;i<m;i++){
                int [] num = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int a = num[0];
                int b = num[1];
                union(a,b);
            }
            Set<Integer> set = new HashSet<>();
            for(int i=1;i<=n;i++){
                set.add(find(i));
            }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
    static void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a == root_b) return;

        if(rank[root_a] > rank[root_b]){
            root[root_b]=root_a;
        }else if(rank[root_a] < rank[root_b]){
            root[root_a]=root_b;
        }else{
            root[root_b]=root_a;
            rank[root_a]++;
        }
    }
    static int find(int v){
        if(root[v]!=v){
            root[v] = find(root[v]);
        }
        return root[v];
    }

}
