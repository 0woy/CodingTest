import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N_15655 {
    static int[]res;
    static int[]arr;
    static Set<Integer> visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        res = new int[m];
        arr = new int[n];
        visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(n,m,0,0);
        System.out.println(sb.toString());

    }

    public static void dfs(int n, int m, int depth, int start){
        if(depth == m){
            for(int v: res){
                sb.append(v+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
            if(!visited.contains(arr[i])){
                visited.add(arr[i]);
                res[depth] = arr[i];
                dfs(n,m,depth+1,i+1);
                visited.remove(arr[i]);
            }
        }
    }
}
