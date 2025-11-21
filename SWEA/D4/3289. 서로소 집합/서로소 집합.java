import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    static int[] root;
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
            for(int i=0;i<=n;i++){
                root[i]=i;
            }
            for(int i=0;i<m;i++){
                int [] num = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int op = num[0];
                if(op == 0) union(num[1], num[2]);
                else{
                    int res =1;
                    int x = find(num[1]);
                    int y = find(num[2]);
                    if(x!=y) res =0;
                    sb.append(res);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);

        if(root_a!=root_b){
            root[root_b]=root_a;
        }
    }
    static int find(int v){
        if(root[v]!=v){
            root[v] = find(root[v]);
        }
        return root[v];
    }

}
